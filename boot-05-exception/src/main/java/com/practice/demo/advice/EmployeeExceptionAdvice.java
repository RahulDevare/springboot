package com.practice.demo.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.demo.exception.EmployeeAlreadyExistException;

@ControllerAdvice
public class EmployeeExceptionAdvice {
	
	@ExceptionHandler(value = EmployeeAlreadyExistException.class)
	public ResponseEntity<Object> alreadyExistException(EmployeeAlreadyExistException exception){
		return new ResponseEntity<>(exception.getKey()+exception.getMessage(),HttpStatus.CONFLICT);
	}
}
