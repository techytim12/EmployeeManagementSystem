package com.example.EmployeeManagementSystem.exception;

public class EmployeeIncorrectFormatException extends RuntimeException{
    public EmployeeIncorrectFormatException() {
    }

    public EmployeeIncorrectFormatException(String message) {
        super(message);
    }
}
