package com.cognizant.truyum.service;

import com.cognizant.truyum.exception.UserAlreadyExistException;
import com.cognizant.truyum.model.Users;

public interface UserDetailService {
	public void signup(Users user) throws UserAlreadyExistException;

}
