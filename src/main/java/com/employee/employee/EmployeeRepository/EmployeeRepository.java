package com.employee.employee.EmployeeRepository;

import com.employee.employee.EmployeeModel.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

