package com.cognizant.authenticationservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.authenticationservice.model.Users;
import com.cognizant.authenticationservice.service.UserDetailService;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
