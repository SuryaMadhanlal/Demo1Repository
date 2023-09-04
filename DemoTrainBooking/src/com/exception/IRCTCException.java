package com.exception;

public class IRCTCException extends Exception{
	
	private String message;

	public IRCTCException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	

}
