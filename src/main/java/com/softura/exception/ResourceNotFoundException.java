package com.softura.exception;


public class ResourceNotFoundException extends RuntimeException{

	
	public ResourceNotFoundException() {
		super("Resource not found Exception Occurs !!");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
