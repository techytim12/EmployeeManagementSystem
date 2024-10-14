# Employee Management System (RESTful API)

## Overview

This project is a RESTful API for managing employee records. It allows HR to perform basic CRUD operations (Create, Read, Update, Delete) on employee records. The system is designed with scalability and security in mind, with support for future integrations.

## Features

- **CRUD operations**: Create, Read, Update, and Delete employee records.
- **Role-based access**: Admins can delete employees, while authenticated users can perform other operations.
- **Data validation**: Validates mandatory fields, unique email addresses, and proper email formats.
- **Filtering**: Retrieve employees based on department and status.
- **Auto-generated fields**: Automatically sets hire date for new employees.
- **Error handling**: Proper error messages and status codes for validation errors and bad requests.
- **Security**: Basic authentication and role-based access control.
- **Swagger documentation**: Test API endpoints directly via Swagger UI.
- **Cloud-ready**: Environment-based configuration and deployable in cloud platforms like AWS or Azure.
- **SQL Database**: Employee records stored in an SQL database with migration support.

## Requirements

- **Java 17+**
- **Spring Boot 3.x**
- **SQL Database (e.g., PostgreSQL/MySQL)**
- **Maven/Gradle**
- **Swagger UI**
- **Hibernate Validator for validation**
- **Flyway/Liquibase for database migrations**

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/employee-management-system.git
cd employee-management-system
```

### 2. Configure the database
Configure your database settings in application.properties or application.yml for different environments (development, production):

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/employeedb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the application
You can run the application locally using:

```bash
mvn spring-boot:run
```
The application will be available at http://localhost:8080.

### 4. Access the Swagger UI
The API documentation can be accessed via Swagger at:

```bash
http://localhost:8080/swagger-ui.html
```

Here, you can view the API documentation and interact with the API endpoints.

### API Endpoints
Create Employee: POST /api/employees

URL: /api/employees

• Request body: JSON object with employee details (excluding ID)

• Response: Created employee object with auto-generated ID and hire date

• Validation: Ensures mandatory fields (first name, last name, email) are provided

Example Request:
```bash
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "department": "IT",
  "jobTitle": "Software Engineer",
  "status": "ACTIVE"
}
```
