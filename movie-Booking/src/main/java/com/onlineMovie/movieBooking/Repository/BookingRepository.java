package com.onlineMovie.movieBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.onlineMovie.movieBooking.Entity.Booking;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // Custom query method to find bookings by userID
    @Query("SELECT b FROM Booking b WHERE b.userID = ?1")
    List<Booking> findByUserID(Integer userID);

}

