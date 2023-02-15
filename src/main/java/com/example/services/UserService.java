package com.example.services;

import com.example.model.User;

public interface UserService {
	
	public User getByUsername(String username);
	public boolean addUser(User user);
}
