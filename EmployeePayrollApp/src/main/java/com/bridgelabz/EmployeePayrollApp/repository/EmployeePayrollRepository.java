package com.bridgelabz.EmployeePayrollApp.repository;

import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}