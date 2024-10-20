package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee savedEmployee = employeeRepository.findById(id).get();
        employeeRepository.delete(savedEmployee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        Employee savedEmployee = employeeRepository.findById(id).get();
        if(Objects.nonNull(employee.getEmail())){
            savedEmployee.setEmail(employee.getEmail());
        }
        if(Objects.nonNull(employee.getDepartment())){
            savedEmployee.setDepartment(employee.getDepartment());
        }
        if(Objects.nonNull(employee.getStatus())){
            savedEmployee.setStatus(employee.getStatus());
        }
        return employeeRepository.save(savedEmployee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
