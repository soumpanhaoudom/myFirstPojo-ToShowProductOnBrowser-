package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String getAllUsers(){
		List<com.example.demo.model.User> users = userService.findAllUsers();
		for(com.example.demo.model.User u:users){
			System.out.println(u);
		} 
		return "index"; 
	}
}
