package com.booking.controller;

//import java.sql.Date;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Booking;
import com.booking.service.BookingService;

@RestController
@Scope(value = "request")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	//private Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping(value = "/booking", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Booking addBooking(@RequestBody Booking booking) {
		//log.debug("Received a request to add a movie: " + movie);
		Booking addedBooking = bookingService.addBooking(booking);
		//log.info("Movie added: ", addedMOvie);
		return addedBooking;
	}
	
	@PutMapping(value = "/booking", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public Booking updateBooking(@RequestBody Booking booking) {
		//log.debug("Received a request to update a movie: " + movie);
		Booking updatedBooking = bookingService.updateBooking(booking);
		//log.info("Movie updated: ", updatedMovie);
		return updatedBooking;
	}
	
	@DeleteMapping(value = "/booking/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteMovieById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to delete a movie with id: " + id);
		bookingService.deleteBookingById(id);
		//log.info("Movie deleted with id: ", id);
	}
	
	@GetMapping(value = "/booking/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Booking getBookingById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to get a movie with id: " + id);
		Booking bookingById = bookingService.getBookingById(id);
		//log.info("Return Value: ", movieById);
		return bookingById;
	}
	
	@GetMapping(value = "/booking", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Booking> getAllmovie() {
		//log.debug("Received a request to view all Movies");
		 List<Booking> allBooking = bookingService.getAllBookings();
		 //log.info("All Movies Return Value: " + allMovie);
		 return allBooking;
		
	}
	
	
}
