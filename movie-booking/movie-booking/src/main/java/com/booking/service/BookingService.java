package com.booking.service;

//import java.sql.Date;
import java.util.List;

import com.booking.entity.Booking;

public interface BookingService {
	
	public Booking addBooking(Booking booking);
	public Booking updateBooking(Booking booking);
	public List<Booking> getAllBookings ();
	public Booking getBookingById (Integer id);
	public void deleteBookingById (Integer id);
	
	
}
