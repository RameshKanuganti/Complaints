package com.valuepack.complaints.exception;

public class BadRequestException  extends Exception {

	private static final long serialVersionUID = -4744430183523721711L;

	private String message = "";

	public BadRequestException(String message) {		
		 super(message);
		 this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}