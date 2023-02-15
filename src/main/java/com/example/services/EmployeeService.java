package com.example.services;

import java.util.List;

import com.example.dto.EmployeeDto;
import com.example.model.Department;

public interface EmployeeService {
	
	public boolean addEmployee(EmployeeDto employeeDto);
	public boolean deleteEmployee(Integer employeeId);
	public EmployeeDto getEmployeeByEmployeeId(Integer employeeId);
	public Department getDepartmentByEmployeeId(Integer employeeId);
	public List<EmployeeDto> getAllEmployee();
}
