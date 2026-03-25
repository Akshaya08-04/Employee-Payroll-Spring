package com.bridgelabz.EmployeePayrollApp.controller;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping({"", "/"})
    public ResponseDTO getEmployeePayrollData() {
        List<EmployeePayrollData> empList = employeePayrollService.getEmployeePayrollData();
        return new ResponseDTO("Get Call Successful", empList);
    }

    @GetMapping("/get/{empId}")
    public ResponseDTO getEmployeePayrollData(@PathVariable int empId) {
        EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(empId);
        return new ResponseDTO("Get Call for ID Successful", empData);
    }

    @PostMapping("/create")
    public ResponseDTO addEmployeePayrollData(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeePayrollData empData = employeePayrollService.createEmployeePayrollData(employeeDTO);
        return new ResponseDTO("Created Employee Payroll Data Successfully", empData);
    }

    @PutMapping("/update/{empId}")
    public ResponseDTO updateEmployeePayrollData(@PathVariable int empId,
                                                 @Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(empId, employeeDTO);
        return new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseDTO deleteEmployeePayrollData(@PathVariable int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        return new ResponseDTO("Deleted Successfully", "Deleted employee id: " + empId);
    }
}