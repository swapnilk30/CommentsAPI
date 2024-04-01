package com.softura.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.softura.helper.ApiResponseMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	// handle Resource Not Found Exception
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessage> handleResourceNotFoundException(ResourceNotFoundException ex){
		ApiResponseMessage responseMessage = new ApiResponseMessage(ex.getMessage(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseMessage,HttpStatus.NOT_FOUND);
	}
}
