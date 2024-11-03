package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.enums.EmployeeStatus;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.exception.EmployeeIncorrectFormatException;
import com.example.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.EmployeeManagementSystem.validator.EmployeeValidator.validEmployee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /*Create Employee*/
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        if(validEmployee(employee)){
            return employeeService.addEmployee(employee);
        }
        throw new EmployeeIncorrectFormatException("Incorrect Employee Format");
    }

    /*Create Multiple Employees*/
    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees) throws InterruptedException {
        List<Employee> employeeList = new ArrayList<>();
        for(Employee employee : employees){
            if(validEmployee(employee)){
                employeeList.add(employeeService.addEmployee(employee));
            } else {
                throw new EmployeeIncorrectFormatException("Incorrect Employee Format");
            }
        }
        return ResponseEntity.ok(employeeList);
    }

    /*Get Employee by ID*/
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        try{
            Employee employee = employeeService.getEmployee(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e){
            throw new EmployeeNotFoundException("Employee "+ id +" Not Found");
        }
    }

    /*Get All Employees */
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String department,
                                                       @RequestParam(required = false)EmployeeStatus status) {
        return ResponseEntity.ok(employeeService.getAllEmployees(department, status));
    }

    /*Update Employee */
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmployee;
        try{
            updatedEmployee = employeeService.updateEmployee(id, employee);
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Employee "+ id +" Not Found");
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    /*Delete Employee */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        try{
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Employee "+ id +" Not Found");
        }
    }
}
