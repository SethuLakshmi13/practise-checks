package com.cognizant.menuitemservice.exception;

public class CartEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;
	
	public  CartEmptyException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}