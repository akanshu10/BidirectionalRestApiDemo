package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "employee_testing")
@RequiredArgsConstructor
public class Employee {
	
	@Id
	private Integer employeeId;
	private String employeeName;
	private String companyName;
	private Integer employeeAge;
//	private String employeePassword;
	@ManyToOne
	private Department employeeDepartment;
	
	@Override
	public boolean equals(Object obj) {
		return this.employeeId==((Employee)obj).getEmployeeId();
	}
	
}
