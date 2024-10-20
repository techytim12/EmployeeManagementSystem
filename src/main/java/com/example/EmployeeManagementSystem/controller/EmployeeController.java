package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exception.EmployeeIncorrectFormatException;
import com.example.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        if(validEmployee(employee)){
            return employeeService.addEmployee(employee);
        }
        throw new EmployeeIncorrectFormatException("Incorrect Employee Format");
    }

    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> addEmployees(@RequestBody List<Employee> employees) {
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

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        try{
            Employee employee = employeeService.getEmployee(id);
            return ResponseEntity.ok(employee);
        } catch (Exception e){
            throw new EmployeeNotFoundException("Employee "+ id +" Not Found");
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

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

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        try{
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Employee "+ id +" Not Found");
        }
    }

    private boolean validEmployee(Employee employee) {
        if(Objects.isNull(employee.getFirstName()) || Objects.isNull(employee.getLastName()) ||
        Objects.isNull(employee.getEmail()) || Objects.isNull(employee.getDepartment()) ||
        Objects.isNull(employee.getJobTitle()) || Objects.isNull(employee.getStatus())) {
            return false;
        }
        if(employee.getFirstName().length() > 20 || employee.getLastName().length() > 20) {
            return false;
        }
        return true;
    }
}
