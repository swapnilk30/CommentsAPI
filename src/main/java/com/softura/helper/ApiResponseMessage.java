package com.softura.helper;

import org.springframework.http.HttpStatus;

public class ApiResponseMessage {
	
	private String message;
	private HttpStatus status;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public ApiResponseMessage(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public ApiResponseMessage() {
		// TODO Auto-generated constructor stub
	}
	

}
