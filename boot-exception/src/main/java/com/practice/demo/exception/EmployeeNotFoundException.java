package com.practice.demo.exception;

public class EmployeeNotFoundException extends ApplicationRuntimeException {

	public EmployeeNotFoundException(String key, String message) {
		super(key,message);
	}

	private static final long serialVersionUID = 1L;
}
