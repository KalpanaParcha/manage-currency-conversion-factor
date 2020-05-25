package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CurrencyConversionFactorDTO {

    @NotEmpty(message = "Country Code must be specified")
	@Pattern(regexp = "[A-Z]{3}", message = "Country Code is not valid")
	private String countryCode;
	
	@NotNull(message = "Conversion Factor must be specified")
	@Pattern(regexp = "(\\d*\\.)?\\d+", message = "Conversion Factor is not valid")
	private String conversionFactor;
	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	
}
