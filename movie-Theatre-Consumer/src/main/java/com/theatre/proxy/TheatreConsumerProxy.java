package com.theatre.proxy;


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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.theatre.entity.Theatre;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="movie-theatre") // same as application name in movie-movie application.properties
public interface TheatreConsumerProxy {

	
	@Retry(name = "theatre-consumer")
	@CircuitBreaker(name="theatre-consumer", fallbackMethod="fallbackMethodForGetTheatreById")
	@GetMapping(value = "/theatre/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Theatre getTheatreById(@PathVariable("id") Integer id);

	@Retry(name = "theatre-consumer")
	@CircuitBreaker(name="theatre-consumer", fallbackMethod="fallbackMethodForGetAllTheatre")
	@GetMapping(value = "/theatre", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Theatre> getAlltheatre();
	
	
	@Retry(name = "theatre-consumer")
	@CircuitBreaker(name="theatre-consumer", fallbackMethod="fallbackMethodForDeleteTheatreById")
	@DeleteMapping(value = "/theatre/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteTheatreById(@PathVariable("id") Integer id);
	
	@Retry(name = "theatre-consumer")
	@CircuitBreaker(name="theatre-consumer", fallbackMethod="samplefallbackMethod")
	@PutMapping(value = "/theatre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Theatre updateTheatre(@RequestBody Theatre theatre);
	
	@Retry(name = "theatre-consumer")
	@CircuitBreaker(name="theatre-consumer", fallbackMethod="samplefallbackMethod")
	@PostMapping(value = "/theatre", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Theatre addTheatre(@RequestBody Theatre theatre);
	

	public default List<Theatre> fallbackMethodForGetAllTheatre(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Theatre>();
	}
	
	public default Theatre fallbackMethodForGetTheatreById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		Theatre fallbackTheatre = new Theatre( id,null,"Invalid Location",null,null, null);
			return fallbackTheatre;
	}
	
	public default void fallbackMethodForDeleteTheatreById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default Theatre samplefallbackMethod(Theatre theatre, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
	
		Theatre fallbackTheatre = new Theatre( null,null,"Invalid Location",null,null, null);
		return fallbackTheatre;
	}
	
	
	}
	
	


