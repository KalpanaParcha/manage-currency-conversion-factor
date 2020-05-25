package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import java.util.List;

import org.springframework.http.HttpStatus;

public class MessageDetail {
	
	private String message;
	
	private List<String> details;
	
	private HttpStatus status;

	public MessageDetail(String message, List<String> details,HttpStatus status) {
		super();
		this.message = message;
		this.details = details;
		this.status =status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
