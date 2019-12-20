package com.cognizant.signupservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.signupservice.exception.UserAlreadyExistException;
import com.cognizant.signupservice.model.Users;
import com.cognizant.signupservice.service.UserDetailService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger( UserController.class);
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("")
	public void signup(@RequestBody @Valid  Users user) throws UserAlreadyExistException  {
		LOGGER.info("Start");
		userDetailService.signup(user);
		LOGGER.info("End");
	}
	
	@SuppressWarnings("unused")
	private PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
	}

}
