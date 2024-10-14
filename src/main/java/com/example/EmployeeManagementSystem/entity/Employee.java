package com.example.EmployeeManagementSystem.entity;

import com.example.EmployeeManagementSystem.enums.EmployeeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String department;
    private String jobTitle;
    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @PrePersist
    protected void onCreate() {
        this.hireDate = new Date();
    }
}
