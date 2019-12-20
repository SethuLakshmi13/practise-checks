package com.cognizant.movie.model;

import java.util.Date;

public class MyError {
	
	String message;
	Date date;
	String Description;

	public MyError(String message, Date date, String description) {
		super();
		this.message = message;
		this.date = date;
		Description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
