package com.purandar.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.purandar.spring.security.model.UserPrincipal;
import com.purandar.spring.security.model.Users;
import com.purandar.spring.security.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = repo.findByUsername(username);

		if (user == null) {
			System.out.println("User Not Found !!!!!!");
			throw new UsernameNotFoundException(username + " User Not Found !!");
		}

		return new UserPrincipal(user);
	}

}
