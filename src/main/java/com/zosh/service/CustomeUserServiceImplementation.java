package com.zosh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zosh.model.User;
import com.zosh.repository.UserRepository;

@Service
public class CustomeUserServiceImplementation implements UserDetailsService {
	
	private UserRepository userRepository;
	
	public CustomeUserServiceImplementation(UserRepository userRepository) {
		this.userRepository=userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("CustomeUserServiceImplementation.loadUserByUsername()"+username);
		Optional<User> user = userRepository.findByEmail(username);
		System.out.println(user.get()+"User entity");
		if(user.isEmpty()) {
			
			throw new UsernameNotFoundException("user not found with email  - "+username);
		}
		//System.out.println("CustomeUserServiceImplementation.loadUserByUsername()"+ user);
		
		List<GrantedAuthority> authorities=new ArrayList<>();
		
		
		return new org.springframework.security.core.userdetails.User(user.get().getEmail(),user.get().getPassword(),authorities);
	}

}
