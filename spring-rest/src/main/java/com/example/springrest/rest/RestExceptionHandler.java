package com.example.springrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<?> handleException(Exception exception) {
		ResponseEntity<?> responseEntity = null;
		
		if (exception instanceof StudentNotFoundException) {
			StudentNotFoundException se = (StudentNotFoundException) exception;
			
			StudentErrorResponse response = new StudentErrorResponse(
					HttpStatus.NOT_FOUND.value(), se.getMessage(), System.currentTimeMillis());
			
			responseEntity = new ResponseEntity<StudentErrorResponse>(response, HttpStatus.NOT_FOUND);
		} else {
			StudentErrorResponse response = new StudentErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), System.currentTimeMillis());
			responseEntity = new ResponseEntity<StudentErrorResponse>(response, HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
}
