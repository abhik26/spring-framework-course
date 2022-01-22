package com.example.spring_rest_crm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException excep) {
		
		CustomerErrorResponse response = new CustomerErrorResponse(
				HttpStatus.NOT_FOUND.value(), excep.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception excep) {
		
		CustomerErrorResponse response = new CustomerErrorResponse(
				HttpStatus.BAD_REQUEST.value(), excep.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
