package com.manage.currency.conversion.microservice.managecurrencyconversionfactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
public class ManageCurrencyConversionFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageCurrencyConversionFactorApplication.class, args);
	}

}
