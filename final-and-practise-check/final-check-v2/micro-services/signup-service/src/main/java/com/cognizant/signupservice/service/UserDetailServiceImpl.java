package com.cognizant.signupservice.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.signupservice.exception.UserAlreadyExistException;
import com.cognizant.signupservice.model.Role;
import com.cognizant.signupservice.model.Users;
import com.cognizant.signupservice.repository.UserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);

	@Override
	@Transactional
	public void signup(Users user) throws UserAlreadyExistException {
		LOGGER.info("Start");
		if( userRepository.findByUserName(user.getUserName())!=null){
			throw new UserAlreadyExistException("User Already Exist");
		}else {
			String encodedPassword = encoder.encode(user.getPassword());
			Set<Role> roleList = new HashSet<Role>();
			roleList.add(new Role(2,"user"));
			user = new Users(0,user.getUserName(), user.getFirstName(), user.getLastName(), encodedPassword, null, roleList);
			userRepository.save(user); 
		}
		LOGGER.info("End");

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
		
	}

}
