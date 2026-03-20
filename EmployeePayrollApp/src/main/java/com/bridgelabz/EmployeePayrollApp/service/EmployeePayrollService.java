package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
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
        return employeePayrollRepository.findById(empId).orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeeDTO employeeDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeeDTO);
        return employeePayrollRepository.save(employeePayrollData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        if (employeePayrollData != null) {
            employeePayrollData.setName(employeeDTO.getName());
            employeePayrollData.setSalary(employeeDTO.getSalary());
            return employeePayrollRepository.save(employeePayrollData);
        }
        return null;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollRepository.deleteById(empId);
    }
}