package com.booking.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Booking;
import com.booking.proxy.BookingConsumerProxy;

@RestController
@Scope("request")
public class BookingConsumerRestController {
	
	@Autowired
	private BookingConsumerProxy bookingconsumerproxy;
	
	private Logger log = LoggerFactory.getLogger(BookingConsumerRestController.class);
	
	@GetMapping("/get-booking/{id}")
	public Booking getBookingById(@PathVariable("id") int id) {
	
		log.debug("In getBookingById with Id: " + id);
		Booking booking = bookingconsumerproxy.getBookingById(id);
		log.debug("In getBookingById with return value Employee: " + booking);
		return booking;
	}

	@GetMapping("/get-booking")
	public List<Booking> getAllBooking() {
	
		List<Booking> booking = bookingconsumerproxy.getAllbooking();
		log.debug("In getAllBooking with return value Booking: " + booking);
		return booking;
		
	}
	
	@DeleteMapping("/delete-booking/{id}")
	public void deleteBookingById(@PathVariable("id") Integer id) {
		log.debug("Request recieved to delete a Booking with Id: " + id);
		bookingconsumerproxy.deleteBookingById(id);
	}
	
	@PostMapping("/add-booking")
	public Booking addBooking(@RequestBody Booking booking) {
		log.debug("Request recieved to add an Employee: " + booking);
		return bookingconsumerproxy.addBooking(booking);
	}
	
	@PutMapping("/update-booking")
	public Booking updateBooking(@RequestBody Booking booking) {
		log.debug("Request recieved to update an Employee: " + booking);
		return bookingconsumerproxy.updateBooking(booking);
	}
	
	
	
	
}
