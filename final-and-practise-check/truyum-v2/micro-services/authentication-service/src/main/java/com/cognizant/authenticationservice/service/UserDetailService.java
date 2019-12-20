package com.cognizant.authenticationservice.service;

import com.cognizant.authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.authenticationservice.model.Users;

public interface UserDetailService {
	public void signup(Users user) throws UserAlreadyExistException;

}
