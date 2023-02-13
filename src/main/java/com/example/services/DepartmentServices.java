package com.example.services;

import java.util.List;

import com.example.model.Department;

public interface DepartmentServices {
	
	public boolean addDepartmentWithoutEmployee(Department department);
	public boolean addDepartmentWithEmployee(Department department);
	public Department getDepartmentByDepartmentId(Integer departmentId);
	public Department getDepartmentByEmployeeId(Integer EmployeeId);
	public List<Department> getAllDepartment();
}
