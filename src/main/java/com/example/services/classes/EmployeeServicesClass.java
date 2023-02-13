package com.example.services.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.dto.EmployeeDto;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.services.EmployeeService;

@Service
public class EmployeeServicesClass implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean addEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		Department department = new Department();
		department.setDepartmentId(employeeDto.getDepartmentId());
		department.setDepartmentName(employeeDto.getDepartmentName());
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setCompanyName(employeeDto.getCompanyName());
		employee.setEmployeeAge(employeeDto.getEmployeeAge());
		employee.setEmployeeDepartment(department);
		
		employeeDao.save(employee);
		
		return true;
	}

	@Override
	public EmployeeDto getEmployeeByEmployeeId(Integer employeeId) {
		EmployeeDto employeeDto = new EmployeeDto();
		Optional<Employee> employeeOptional = employeeDao.findById(employeeId);
		employeeDto.setEmployeeId(employeeOptional.get().getEmployeeId());
		employeeDto.setEmployeeName(employeeOptional.get().getEmployeeName());
		employeeDto.setCompanyName(employeeOptional.get().getCompanyName());
		employeeDto.setEmployeeAge(employeeOptional.get().getEmployeeAge());
		employeeDto.setDepartmentId(employeeOptional.get().getEmployeeDepartment().getDepartmentId());
		employeeDto.setDepartmentName(employeeOptional.get().getEmployeeDepartment().getDepartmentName());
		
		return employeeDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		List<Employee> employees = employeeDao.findAll();
		for(Employee employee : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setEmployeeName(employee.getEmployeeName());
			employeeDto.setCompanyName(employee.getCompanyName());
			employeeDto.setEmployeeAge(employee.getEmployeeAge());
			employeeDto.setDepartmentId(employee.getEmployeeDepartment().getDepartmentId());
			employeeDto.setDepartmentName(employee.getEmployeeDepartment().getDepartmentName());
			
			employeeDtos.add(employeeDto);
		}
		return employeeDtos;
	}
	
	
	
	//	EmployeeDto for string department Id and department name  in each employee
	public EmployeeDto createEmployeeDtoFromEmployee(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employee.getEmployeeId());
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setCompanyName(employee.getCompanyName());
		employeeDto.setEmployeeAge(employee.getEmployeeAge());
		employeeDto.setDepartmentId(employee.getEmployeeDepartment().getDepartmentId());
		employeeDto.setDepartmentName(employee.getEmployeeDepartment().getDepartmentName());
		return employeeDto;
	}
	
	public Employee createEmployeeFromEmployeeDto(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setEmployeeName(employeeDto.getEmployeeName());
		employee.setEmployeeAge(employeeDto.getEmployeeAge());
		employee.setCompanyName(employeeDto.getCompanyName());
		
		// Department object to store department id and name in employee
 		Department department = new Department();
		department.setDepartmentId(employeeDto.getDepartmentId());
		department.setDepartmentName(employeeDto.getDepartmentName());
		
		employee.setEmployeeDepartment(department);
		
		return employee;
	}

}
