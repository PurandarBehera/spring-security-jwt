package com.purandar.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purandar.spring.security.model.Users;
import com.purandar.spring.security.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public Users registerUser(@RequestBody Users user) {
		return userService.saveUser(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		
		return userService.verify(user);
	}

}
