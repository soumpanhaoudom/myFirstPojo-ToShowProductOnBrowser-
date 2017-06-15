package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository implements IUserRepository {

	
	private ArrayList<User> users;
	public UserRepository() {
		users = new ArrayList<>();
		for(int i=0;i<10;i++){
			User user = new User(i,"user"+i,"pwd"+i);
			users.add(user);
			
		}
	}
	@Override
	public List<User> findAllUser() {
		return users; 
	}
}
