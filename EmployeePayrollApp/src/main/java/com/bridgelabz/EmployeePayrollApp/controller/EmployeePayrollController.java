package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/get/{id}")
    public String getById(@PathVariable int id) {
        return "Employee ID: " + id;
    }

    @PostMapping("/create")
    public String create(@RequestBody EmployeeDTO emp) {
        employeePayrollService.createEmployeePayrollData(emp);
        return "Employee Created Successfully";
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable int id, @RequestBody EmployeeDTO emp) {
        employeePayrollService.updateEmployeePayrollData(id, emp);
        return "Employee Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        employeePayrollService.deleteEmployeePayrollData(id);
        return "Employee Deleted Successfully";
    }
}