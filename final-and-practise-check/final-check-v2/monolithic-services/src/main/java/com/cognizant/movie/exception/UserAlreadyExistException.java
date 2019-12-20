package com.cognizant.movie.exception;

public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;
	
	public UserAlreadyExistException(String message) {
		this.message=message;
		
	}
	public String getMessage() {
		return message;
	}
	
}
