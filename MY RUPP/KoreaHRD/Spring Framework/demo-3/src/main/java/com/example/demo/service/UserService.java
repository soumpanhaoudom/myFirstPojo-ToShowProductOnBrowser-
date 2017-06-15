package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAllUsers() {
		
		List<User> users = userRepository.findAllUser(); 
		return users;
	}

}
