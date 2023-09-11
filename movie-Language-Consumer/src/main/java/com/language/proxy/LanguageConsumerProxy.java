package com.language.proxy;


import java.util.ArrayList;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.language.entity.Language;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="movie-language") // same as application name in movie-movie application.properties
public interface LanguageConsumerProxy {

	
	@Retry(name = "language-consumer")
	@CircuitBreaker(name="language-consumer", fallbackMethod="fallbackMethodForGetLanguageById")
	@GetMapping(value = "/language/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Language getLanguageById(@PathVariable("id") Integer id);

	@Retry(name = "language-consumer")
	@CircuitBreaker(name="language-consumer", fallbackMethod="fallbackMethodForGetAllLanguage")
	@GetMapping(value = "/language", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Language> getAlllanguage();
	
	
	@Retry(name = "language-consumer")
	@CircuitBreaker(name="language-consumer", fallbackMethod="fallbackMethodForDeleteLanguageById")
	@DeleteMapping(value = "/language/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteLanguageById(@PathVariable("id") Integer id);
	
	@Retry(name = "language-consumer")
	@CircuitBreaker(name="language-consumer", fallbackMethod="samplefallbackMethod")
	@PutMapping(value = "/language", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Language updateLanguage(@RequestBody Language language, @RequestParam("id") Integer id);
	
	@Retry(name = "language-consumer")
	@CircuitBreaker(name="language-consumer", fallbackMethod="samplefallbackMethod")
	@PostMapping(value = "/language", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Language addLanguage(@RequestBody Language language);
	public default List<Language> fallbackMethodForGetAllLanguagee(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Language>();
	}
	
	public default Language fallbackMethodForGetLanguageById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Language fallbackLanguage = new Language( id,"Invalid Language");
			return fallbackLanguage;
	}
	
	public default void fallbackMethodForDeleteLanguageById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Language samplefallbackMethod(Language language, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
	
		Language fallbackLanguage = new Language( null,"Invalid Language");
		return fallbackLanguage;
	}
	
	
	}
	
	
	

