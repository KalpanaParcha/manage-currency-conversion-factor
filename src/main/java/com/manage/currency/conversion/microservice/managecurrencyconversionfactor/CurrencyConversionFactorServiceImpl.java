package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionFactorServiceImpl implements CurrencyConversionFactorService{
	
	@Autowired
	private CurrencyConversionFactorRepository currencyConversionFactorRepository;
	
	@Autowired
	private CountryCodeRepository countryCodeRepository;

	@Override
	public ResponseEntity<Object> addConversionFactor(CurrencyConversionFactorDTO currencyConversionFactor) {
		// TODO Auto-generated method stub
		List<String> details=new ArrayList<String>();
		details.add(currencyConversionFactor.getCountryCode());
		CountryCode countryCode=countryCodeRepository.findByCountryCode(currencyConversionFactor.getCountryCode());
		if(null!=countryCode && null!=countryCode.getId() && !"".equals(countryCode.getId().toString())) {
			CurrencyConversionFactor currencyConversionFactorObj=new CurrencyConversionFactor();
			currencyConversionFactorObj.setConversionFactor(currencyConversionFactor.getConversionFactor());
			currencyConversionFactorObj.setCountryCode(countryCode);
			CurrencyConversionFactor currencyConversionFactorObjexist=currencyConversionFactorRepository.findByCountryCode_Id(countryCode.getId());
			if(currencyConversionFactorObjexist!=null) {
				MessageDetail error=new MessageDetail("Conversion Factor is already added for Country Code.", details,HttpStatus.OK);
				return new ResponseEntity<Object>(error, HttpStatus.OK);
			}
			else{
				currencyConversionFactorObj=currencyConversionFactorRepository.save(currencyConversionFactorObj);
				if(null!=currencyConversionFactorObj.getId() && !"".equals(currencyConversionFactorObj.getId().toString())) {
					MessageDetail error=new MessageDetail("Conversion Factor added for Country Code.", details,HttpStatus.CREATED);
					return new ResponseEntity<Object>(error, HttpStatus.CREATED);
				}
			}
			
		}else {
			MessageDetail error=new MessageDetail("Country Code does not exists.", details,HttpStatus.OK);
			return new ResponseEntity<Object>(error, HttpStatus.OK);
		}
		
		return null;
		
	}
	
	
	@Override
	public BigDecimal getConversionFactor(CountryCodeDTO countryCodeDTO) {
		// TODO Auto-generated method stub
		List<String> details=new ArrayList<String>();
		details.add(countryCodeDTO.getCountryCode());
		BigDecimal convertedAmt=new BigDecimal(0.0);
		CountryCode countryCode=countryCodeRepository.findByCountryCode(countryCodeDTO.getCountryCode());
		CurrencyConversionFactor currencyConversionFactorObjexist=null;
		if(null!=countryCode && null!=countryCode.getId() && !"".equals(countryCode.getId().toString())) {
			currencyConversionFactorObjexist=currencyConversionFactorRepository.findByCountryCode_Id(countryCode.getId());
			if(currencyConversionFactorObjexist!=null) {
				details=new ArrayList<String>();
				details.add(currencyConversionFactorObjexist.getConversionFactor());
				convertedAmt=new BigDecimal(currencyConversionFactorObjexist.getConversionFactor());
				MessageDetail error=new MessageDetail("Conversion Factor exists for Country Code.", details,HttpStatus.OK);
				return convertedAmt;
			}else {
				
				throw new RecordNotFoundException("Conversion Factor does not exists for Country Code."+ countryCode.getCountryCode());
			}
		}else {
			
			throw new RecordNotFoundException("Country Code does not exists"+ countryCode.getCountryCode());
		}
		
	}
	
	@Override
	public BigDecimal getConversionFactorFallback() {
		BigDecimal convertedAmt=new BigDecimal(20.0);
		return convertedAmt;
	}
	
	@Override
	public ResponseEntity<Object> updateConversionFactor(CurrencyConversionFactorDTO currencyConversionFactor) {
		// TODO Auto-generated method stub
		List<String> details=new ArrayList<String>();
		details.add(currencyConversionFactor.getCountryCode());
		CountryCode countryCode=countryCodeRepository.findByCountryCode(currencyConversionFactor.getCountryCode());
		if(null!=countryCode && null!=countryCode.getId() && !"".equals(countryCode.getId().toString())) {
			CurrencyConversionFactor currencyConversionFactorObjexist=currencyConversionFactorRepository.findByCountryCode_Id(countryCode.getId());
			if(currencyConversionFactorObjexist!=null) {
				currencyConversionFactorObjexist.setConversionFactor(currencyConversionFactor.getConversionFactor());
				currencyConversionFactorObjexist=currencyConversionFactorRepository.save(currencyConversionFactorObjexist);
				if(null!=currencyConversionFactorObjexist.getId() && !"".equals(currencyConversionFactorObjexist.getId().toString())) {
					MessageDetail error=new MessageDetail("Conversion Factor updated for Country Code.", details,HttpStatus.OK);
					return new ResponseEntity<Object>(error, HttpStatus.OK);
				}
			}else {
				MessageDetail error=new MessageDetail("Conversion Factor for this Country Code does not exists", details,HttpStatus.OK);
				return new ResponseEntity<Object>(error, HttpStatus.OK);
			}
				
		}else {
			MessageDetail error=new MessageDetail("Country Code does not exists.", details,HttpStatus.OK);
			return new ResponseEntity<Object>(error, HttpStatus.OK);
		}
		return null;
	}
}
