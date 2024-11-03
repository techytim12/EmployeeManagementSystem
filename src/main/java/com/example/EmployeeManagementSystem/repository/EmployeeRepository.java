package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.enums.EmployeeStatus;
import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartment(String department);
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByDepartmentAndStatus(String department, EmployeeStatus status);
}
