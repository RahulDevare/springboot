package com.practice.demo.exception;

public class EmployeeAlreadyExistException extends ApplicationRuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmployeeAlreadyExistException(String key, String message) {
		super(key, message);
	}

}
