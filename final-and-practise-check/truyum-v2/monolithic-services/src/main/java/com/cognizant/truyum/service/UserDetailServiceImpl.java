package com.cognizant.truyum.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.UserAlreadyExistException;
import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;


	@Override
	public void signup(Users user) throws UserAlreadyExistException {
		
		if( userRepository.findByUserName(user.getUserName())!=null){
			throw new UserAlreadyExistException("User Already Exist");
		}else {
			String encodedPassword = encoder.encode(user.getPassword());
			Set<Role> roleList = new HashSet<Role>();
			roleList.add(new Role(2,"user"));
			user = new Users(0,user.getUserName(), user.getFirstName(), user.getLastName(), encodedPassword, null, roleList);
			userRepository.save(user); 
		}

	}

}
