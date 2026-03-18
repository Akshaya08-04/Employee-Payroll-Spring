package com.bridgelabz.EmployeePayrollApp.controller;


import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getAll() {
        return "Employee Payroll App is running";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable int id) {
        return "Employee ID: " + id;
    }

    @PostMapping("/create")
    public String create(@RequestBody EmployeeDTO emp) {
        return "Created: " + emp.name + " Salary: " + emp.salary;
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody EmployeeDTO emp) {
        return "Updated ID: " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        return "Deleted ID: " + id;
    }
}