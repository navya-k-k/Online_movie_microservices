package com.booking.proxy;


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

import com.booking.entity.Booking;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="movie-booking") // same as application name in movie-movie application.properties
public interface BookingConsumerProxy {

	
	@Retry(name = "booking-consumer")
	@CircuitBreaker(name="booking-consumer", fallbackMethod="fallbackMethodForGetBookingById")
	@GetMapping(value = "/booking/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Booking getBookingById(@PathVariable("id") Integer id);

	@Retry(name = "booking-consumer")
	@CircuitBreaker(name="booking-consumer", fallbackMethod="fallbackMethodForGetAllBooking")
	@GetMapping(value = "/booking", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Booking> getAllbooking();
	
	
	@Retry(name = "booking-consumer")
	@CircuitBreaker(name="booking-consumer", fallbackMethod="fallbackMethodForDeleteBookingById")
	@DeleteMapping(value = "/booking/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteBookingById(@PathVariable("id") Integer id);
	
	@Retry(name = "booking-consumer")
	@CircuitBreaker(name="booking-consumer", fallbackMethod="samplefallbackMethod")
	@PutMapping(value = "/booking", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Booking updateBooking(@RequestBody Booking booking);
	
	@Retry(name = "booking-consumer")
	@CircuitBreaker(name="booking-consumer", fallbackMethod="samplefallbackMethod")
	@PostMapping(value = "/booking", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Booking addBooking(@RequestBody Booking booking);
	

	public default List<Booking> fallbackMethodForGetAllBooking(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<Booking>();
	}
	
	public default Booking fallbackMethodForGetBookingById(Integer id, Throwable cause) {
        System.out.println("Exception raised with message: ===> " + cause.getMessage());
        Booking fallbackBooking = new Booking(id, null, null, null, null, null, false);
        return fallbackBooking;
	}
	
	public default void fallbackMethodForDeleteBookingById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	public default Booking samplefallbackMethod(Booking booking, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
	
		Booking fallbackBooking = new Booking( null,null,null,null, null,null,false);
		return fallbackBooking;
	}
	
}
	
	


