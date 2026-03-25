package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollRepository.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollRepository.findById(empId)
                .orElseThrow(() ->
                        new EmployeePayrollException("Employee with ID " + empId + " not found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeeDTO employeeDTO) {
        EmployeePayrollData employeeData =
                new EmployeePayrollData(employeeDTO.getName(), employeeDTO.getSalary());
        return employeePayrollRepository.save(employeeData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        EmployeePayrollData employeeData = this.getEmployeePayrollDataById(empId);
        employeeData.setName(employeeDTO.getName());
        employeeData.setSalary(employeeDTO.getSalary());
        return employeePayrollRepository.save(employeeData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeeData = this.getEmployeePayrollDataById(empId);
        employeePayrollRepository.delete(employeeData);
    }
}