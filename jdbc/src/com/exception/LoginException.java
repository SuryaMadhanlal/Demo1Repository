package com.exception;

public class LoginException extends Exception{
	private String errorMessage;

	public LoginException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.errorMessage;
	}

}
