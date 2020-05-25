package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionFactorRepository extends JpaRepository<CurrencyConversionFactor, Long>{
 
	//@Query("from CURRENCY_CONVERSION_FACTOR a inner join COUNTRY_CODE  b")
	
	//@EntityGraph(value="CurrencyConversionFactor.country_code_id" , type = EntityGraphType.FETCH)
	//public CurrencyConversionFactor findByCountryCodeId(Long id);
	
	/*@EntityGraph(attributePaths = {"tags"})
	@Query("Select c from CurrencyConversionFactor c where c.country_code_id=:country_id ")
	CurrencyConversionFactor findByCountryCodeId(@Param("country_id") Long id);*/
	
	CurrencyConversionFactor findByCountryCode_Id(long id);
	
	
	
	
}
