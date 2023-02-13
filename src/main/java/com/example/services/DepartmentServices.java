package com.example.services;

import java.util.List;

import com.example.dto.DepartmentDto2;
import com.example.model.Department;

public interface DepartmentServices {
	
	public boolean addDepartmentWithoutEmployee(DepartmentDto2 departmentDto2);
	public boolean addDepartmentWithEmployee(Department department);
	public Department getDepartmentByDepartmentId(Integer departmentId);
	public Department getDepartmentByEmployeeId(Integer EmployeeId);
	public List<Department> getAllDepartment();
}
