package com.example.services;

import java.util.List;

import com.example.dto.EmployeeDto;
import com.example.model.Employee;

public interface EmployeeService {
	
	public boolean addEmployee(Employee employee);
	public EmployeeDto getEmployeeByEmployeeId(Integer employeeId);
	public List<EmployeeDto> getAllEmployee();
}