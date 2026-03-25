package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private final List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                .filter(employee -> employee.getId() == empId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeeDTO employeeDTO) {
        int newId = employeePayrollList.size() + 1;
        EmployeePayrollData employeeData = new EmployeePayrollData(
                newId,
                employeeDTO.getName(),
                employeeDTO.getSalary()
        );
        employeePayrollList.add(employeeData);
        return employeeData;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        EmployeePayrollData employeeData = this.getEmployeePayrollDataById(empId);
        if (employeeData != null) {
            employeeData.setName(employeeDTO.getName());
            employeeData.setSalary(employeeDTO.getSalary());
        }
        return employeeData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollList.removeIf(employee -> employee.getId() == empId);
    }
}