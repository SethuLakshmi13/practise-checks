package com.cognizant.movie.exception;

public class FavoritesEmptyException extends Exception {

	private static final long serialVersionUID = 1L;
	String message;

	public FavoritesEmptyException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
