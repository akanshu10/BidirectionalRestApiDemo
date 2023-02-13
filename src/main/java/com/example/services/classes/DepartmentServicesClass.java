package com.example.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DepartmentDao;
import com.example.dto.DepartmentDto;
import com.example.dto.EmployeeDto;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.services.DepartmentServices;

@Service
public class DepartmentServicesClass implements DepartmentServices {
	
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public boolean addDepartmentWithoutEmployee(Department department) {
		departmentDao.save(department);
		return true;
	}

	
	@Override
	public boolean addDepartmentWithEmployee(Department department) {
		departmentDao.save(this.createDepartmentByDepartmentDto(this.createDepartmentDtoByDepartment(department)));
		return true;
	}

	@Override
	public Department getDepartmentByDepartmentId(Integer departmentId) {
		return departmentDao.findById(departmentId).get();
	}
	
	@Override
	public Department getDepartmentByEmployeeId(Integer EmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentDao.findAll();
	}

	
	
	public DepartmentDto createDepartmentDtoByDepartment(Department department) {
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentId(department.getDepartmentId());
		departmentDto.setDepartmentName(department.getDepartmentName());
		
		List<Employee> employees = department.getListOfEmployees();
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for(Employee employee:employees) {
			employee.setEmployeeDepartment(department);
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setDepartmentId(employee.getEmployeeDepartment().getDepartmentId());
			employeeDto.setCompanyName(employee.getCompanyName());
			employeeDto.setDepartmentName(employee.getEmployeeDepartment().getDepartmentName());
			employeeDto.setEmployeeAge(employee.getEmployeeAge());
			employeeDto.setEmployeeName(employee.getEmployeeName());
			
			employeeDtos.add(employeeDto);
		}
		
		departmentDto.setEmployeesOfDepartment(employees);
		departmentDto.setEmployeesDtoOfDepatment(employeeDtos);
		return departmentDto;
	}
	
	public Department createDepartmentByDepartmentDto(DepartmentDto departmentDto) {
		Department department = new Department();
		department.setDepartmentId(departmentDto.getDepartmentId());
		department.setDepartmentName(departmentDto.getDepartmentName());
		department.setListOfEmployees(departmentDto.getEmployeesOfDepartment());
//		department.setListOfEmployees(departmentDto.getEmployeesOfDepatment());
		
		return department;
	}

	
	
	
}
