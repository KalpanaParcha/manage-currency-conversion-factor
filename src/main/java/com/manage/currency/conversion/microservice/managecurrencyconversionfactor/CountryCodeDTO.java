package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CountryCodeDTO {
	@NotEmpty(message = "Country Code must be specified")
	@Pattern(regexp = "[A-Z]{3}", message = "Country Code is not valid")
	private String countryCode;
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
