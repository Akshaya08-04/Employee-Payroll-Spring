package com.bridgelabz.EmployeePayrollApp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {

    @NotBlank(message = "Name should not be empty")
    private String name;

    @Min(value = 500, message = "Salary should be at least 500")
    private long salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}