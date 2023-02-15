package com.example.dto;

import lombok.Data;

@Data
public class EmployeeDto {
	
	private Integer employeeId;
	private String employeeName;
	private String companyName;
	private String employeePassword;
	private Integer employeeAge;
	private Integer departmentId;
	private String departmentName;
}
