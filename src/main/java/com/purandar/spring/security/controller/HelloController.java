package com.purandar.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		return "Hello , Spring Security " + request.getSession().getId();
	}

}
