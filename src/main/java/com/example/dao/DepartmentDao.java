package com.example.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Serializable> {

}
