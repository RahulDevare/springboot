package com.practice.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends ApplicationRuntimeException {

	public EmployeeNotFoundException(String key, String message) {
		super(key,message);
	}

	private static final long serialVersionUID = 1L;
}
