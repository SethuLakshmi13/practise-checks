package com.cognizant.movie.service;

import com.cognizant.movie.exception.UserAlreadyExistException;
import com.cognizant.movie.model.Users;

public interface UserDetailService {
	public void signup(Users user) throws UserAlreadyExistException;

}
