package com.example.EmployeeManagementSystem.validator;

import com.example.EmployeeManagementSystem.model.Employee;

import java.util.Objects;

public class EmployeeValidator {

    public static boolean validEmployee(Employee employee) {
         return !Objects.isNull(employee.getFirstName()) && !Objects.isNull(employee.getLastName()) &&
                !Objects.isNull(employee.getEmail()) && !Objects.isNull(employee.getDepartment()) &&
                !Objects.isNull(employee.getJobTitle()) && !Objects.isNull(employee.getStatus()) &&
                 employee.getFirstName().length() < 10 && employee.getLastName().length() < 10;
    }
}
