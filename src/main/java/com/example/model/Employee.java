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
	@ManyToOne
	@JsonIgnore
	private Department employeeDepartment;
}
