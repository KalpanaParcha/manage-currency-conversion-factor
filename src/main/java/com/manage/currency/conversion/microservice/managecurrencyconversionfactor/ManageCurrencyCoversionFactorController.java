package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Validated
public class ManageCurrencyCoversionFactorController {

	
	
	@Autowired 
	private CurrencyConversionFactorService currencyConversionFactorService;
	
	
	@PostMapping(path="/addConversionFactor/countryCode/{countryCode}/conversionFactor/{conversionFactor}")
	public ResponseEntity<Object> addConversionFactor(@PathVariable("countryCode") @NotEmpty @Pattern(regexp = "[A-Z]{3}") String countryCode,@PathVariable("conversionFactor") @NotNull @Pattern(regexp = "(\\d*\\.)?\\d+") String conversionFactor) {
		CurrencyConversionFactorDTO currencyConversionFactorDTO=new CurrencyConversionFactorDTO();
		currencyConversionFactorDTO.setCountryCode(countryCode);
		currencyConversionFactorDTO.setConversionFactor(conversionFactor);
		return currencyConversionFactorService.addConversionFactor(currencyConversionFactorDTO);
	}
	
	@GetMapping(path="/getConversionFactor/countryCode/{countryCode}")
	@HystrixCommand(fallbackMethod ="fallbackGetConversionFactor" )
	public BigDecimal getConversionFactor(@PathVariable("countryCode") @NotEmpty @Pattern(regexp = "[A-Z]{3}") String countryCode) {
		CountryCodeDTO countryCodeDTO=new CountryCodeDTO();
		countryCodeDTO.setCountryCode(countryCode);
		return currencyConversionFactorService.getConversionFactor(countryCodeDTO);
	}
	
	public BigDecimal fallbackGetConversionFactor(@PathVariable("countryCode") @NotEmpty @Pattern(regexp = "[A-Z]{3}") String countryCode) {
		return currencyConversionFactorService.getConversionFactorFallback();
	}
	
	@PutMapping(path="/updateConversionFactor/countryCode/{countryCode}/conversionFactor/{conversionFactor}" )
	public ResponseEntity<Object> updateConversionFactor(@PathVariable("countryCode") @NotEmpty @Pattern(regexp = "[A-Z]{3}") String countryCode,
														 @PathVariable("conversionFactor") @NotNull @Pattern(regexp = "(\\d*\\.)?\\d+") String conversionFactor
			) {
		CurrencyConversionFactorDTO currencyConversionFactorDTO=new CurrencyConversionFactorDTO();
		currencyConversionFactorDTO.setCountryCode(countryCode);
		currencyConversionFactorDTO.setConversionFactor(conversionFactor);
		return currencyConversionFactorService.updateConversionFactor(currencyConversionFactorDTO);
	}
}
