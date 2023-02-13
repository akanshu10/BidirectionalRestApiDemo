package com.example.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Serializable> {
	
//	@Modifying
//	@Query("delete from Employee employee where employee.employeeId = ?1")
//	void delete(Integer employeeId);
}
