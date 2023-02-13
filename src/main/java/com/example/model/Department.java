package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "department_testing")
public class Department {
	
	@Id
	private Integer departmentId;
	private String departmentName;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "employeeDepartment",orphanRemoval = true)
//	@JsonInclude(JsonInclude.Include.NON_EMPTY)
//	@JsonIgnore
	private List<Employee> listOfEmployees;
	
}
