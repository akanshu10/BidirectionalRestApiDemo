package com.example.services.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.services.UserService;

@Service
public class UserServicesClasses implements UserService {

	@Autowired
	private UserDao  userDao;
	
	@Override
	public User getByUsername(String username) {
		User user = userDao.getUserByUsername(username);
		return user;
	}

	@Override
	public boolean addUser(User user) {
		userDao.save(user);
		return false;
	}

	

}
