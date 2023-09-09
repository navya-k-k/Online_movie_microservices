package com.booking.repository;

//import java.sql.Date;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.entity.Booking;

@Repository(value="bookingRepository")
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	
}
