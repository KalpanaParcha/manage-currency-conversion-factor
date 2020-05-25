package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CountryCode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,unique = true,name = "currency_country_code")
	private String countryCode;
	
	public CountryCode() {
		// TODO Auto-generated constructor stub
	}
	
	

	public CountryCode(Long id, String countryCode) {
		super();
		this.id = id;
		this.countryCode = countryCode;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
}
