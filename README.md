# EmployeePayrollApp

EmployeePayrollApp is a Spring Boot backend project built to handle REST API requests for the Employee Payroll UI. In this project, the frontend connects to the Spring Boot application instead of calling a JSON server directly, and the REST endpoints can be tested using `curl`. :contentReference[oaicite:0]{index=0}

## Project Details

- **Project Name:** `EmployeePayrollApp`
- **Group / Root Package:** `com.bridgelabz`
- **Package Name:** `com.bridgelabz.employeepayrollapp`
- **Type:** Maven Project
- **Language:** Java
- **Backend Framework:** Spring Boot

These names and package details follow the setup described in the project document. :contentReference[oaicite:1]{index=1}

## Features Covered

### UC1: Employee Payroll App Setup
- Create the Spring Boot Employee Payroll project
- Connect backend with Employee Payroll UI
- Replace JSON server calls with Spring Boot server calls
- Test REST APIs using `curl` commands :contentReference[oaicite:2]{index=2}

### UC2: Supporting REST API Calls in Controller
- Create a REST controller
- Demonstrate major HTTP methods
- Configure MySQL connectivity in `application.properties`
- Ensure data is transmitted properly through REST calls
- Test endpoints using `curl` :contentReference[oaicite:3]{index=3}

## Dependencies Used

The project uses the following dependencies:

- Spring Web
- Spring Boot DevTools
- Validation
- MySQL Driver
- Spring Data JPA

These dependencies are required for building REST APIs, validating request data, connecting to MySQL, and storing data using JPA. 