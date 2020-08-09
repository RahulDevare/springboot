package com.practice.demo.exception;

public class ApplicationRuntimeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String key;
	private String message;
	
	public ApplicationRuntimeException(String key, String message) {
		this.key = key;
		this.message = message;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
