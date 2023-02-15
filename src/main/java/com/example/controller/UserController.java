package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@PostMapping("/user1")
	public boolean addUser(@RequestBody User user) {
		User user1 = new User();
		user1.setUserId(user.getUserId());
		user1.setEmail(user.getEmail());
		user1.setUsername(user.getUsername());
		user1.setUserRole(user.getUserRole());
		user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.addUser(user1);
		return true;
	}
}
