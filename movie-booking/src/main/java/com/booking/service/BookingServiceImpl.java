package com.booking.service;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.booking.entity.Booking;
import com.booking.repository.BookingRepository;

@Service
@Scope(value ="singleton")
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking getBookingById(Integer id) {
		return bookingRepository.findById(id).get();
	}

	@Override
	public void deleteBookingById(Integer id) {
		bookingRepository.deleteById(id);
		
	}
	

}
