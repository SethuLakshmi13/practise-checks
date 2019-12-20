package com.cognizant.signupservice.service;

import com.cognizant.signupservice.exception.UserAlreadyExistException;
import com.cognizant.signupservice.model.Users;

public interface UserDetailService {
	public void signup(Users user) throws UserAlreadyExistException;

}
