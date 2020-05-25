package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

public interface CurrencyConversionFactorService {

	public ResponseEntity<Object> addConversionFactor(CurrencyConversionFactorDTO currencyConversionFactor);
	
	public BigDecimal getConversionFactor(CountryCodeDTO countryCodeDTO);
	
	public BigDecimal getConversionFactorFallback();
	
	public ResponseEntity<Object> updateConversionFactor(CurrencyConversionFactorDTO currencyConversionFactor);
	
}
