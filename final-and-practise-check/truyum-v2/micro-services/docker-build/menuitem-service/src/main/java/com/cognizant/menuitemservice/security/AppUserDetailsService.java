package com.cognizant.menuitemservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.model.Users;
import com.cognizant.menuitemservice.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	public AppUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser;
		Users user=userRepository.findByUserName(username);
		if(user==null) {
			
			throw new UsernameNotFoundException("User not found");
		}
		else {
			appUser=new AppUser(user);
		}
		return appUser;
	}

}
