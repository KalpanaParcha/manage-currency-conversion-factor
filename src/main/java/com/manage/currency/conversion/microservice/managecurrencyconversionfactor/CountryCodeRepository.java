package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryCodeRepository extends JpaRepository<CountryCode, Long>{

	CountryCode findByCountryCode(String countryCode);
}
