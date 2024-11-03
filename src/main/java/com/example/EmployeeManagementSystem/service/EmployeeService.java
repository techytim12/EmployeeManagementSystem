package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.enums.EmployeeStatus;
import com.example.EmployeeManagementSystem.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees(String department, EmployeeStatus status);
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
