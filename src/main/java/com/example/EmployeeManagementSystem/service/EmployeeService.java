package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
