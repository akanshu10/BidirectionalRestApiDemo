package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name =  "User_testing")
public class User {
	
	@Id
	private int userId;
	private String username;
	private String email;
	private String password;
	private String userRole;
}
