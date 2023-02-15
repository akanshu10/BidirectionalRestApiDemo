package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.dao.UserDao;
import com.example.model.User;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userdao.getUserByUsername(username);
		
		CustomUserDetail customUserDetail = new CustomUserDetail(user);
		return customUserDetail;
		
	}

}
