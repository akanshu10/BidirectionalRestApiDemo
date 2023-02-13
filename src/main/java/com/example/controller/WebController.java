package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDto;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.services.DepartmentServices;
import com.example.services.EmployeeService;

@RestController
public class WebController {
	
	@Autowired
	public EmployeeService employeeService;
	@Autowired
	public DepartmentServices departmentServices;
	
	
	@PostMapping("/department")
	public boolean addDepartmentWithoutEmployee(@RequestBody Department department) {
		return departmentServices.addDepartmentWithoutEmployee(department);
	}
	
	@PostMapping("/department/employee")
	public boolean addDepartmentWithEmployee(@RequestBody Department department) {
		return departmentServices.addDepartmentWithEmployee(department);
	}
	
	@GetMapping("/department/{departmentId}")
	public Department getDepartmentByDepartmentId(@PathVariable("departmentId") Integer departmentId) {
		return departmentServices.getDepartmentByDepartmentId(departmentId);
	}
	
	@GetMapping("/department")
	public List<Department> getAllDepartment(){
		return departmentServices.getAllDepartment();
	}
	
	@GetMapping("/employee/{employeeId}")
	public EmployeeDto getEmployeeByEmployeeId(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}
	
	@GetMapping("/employee")
	public List<EmployeeDto> getAllEmployees(){
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/employee")
	public boolean addEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.addEmployee(employeeDto);
	}
	
	
}
