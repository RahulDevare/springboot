package com.practice.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.practice.demo.exception.EmployeeAlreadyExistException;
import com.practice.demo.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeExceptionAdvice {
	
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object> notFoundException(EmployeeNotFoundException exception){
		return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmployeeAlreadyExistException.class)
	public ResponseEntity<Object> alreadyExistException(EmployeeAlreadyExistException exception){
		return new ResponseEntity<>(exception,HttpStatus.CONFLICT);
	}
}
