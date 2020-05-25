package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String exception) {
		// TODO Auto-generated constructor stub
		super(exception);
	}
}
