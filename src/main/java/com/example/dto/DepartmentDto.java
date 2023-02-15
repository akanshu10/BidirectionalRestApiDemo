package com.example.dto;

import java.util.List;

import com.example.model.Employee;

import lombok.Data;

@Data
public class DepartmentDto {
	
	
	private Integer departmentId;
	private String departmentName;
//	private String departmentPassword;
	private List<EmployeeDto> employeesDtoOfDepatment;
	private List<Employee> employeesOfDepartment;
}
