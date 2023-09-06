package com.onlineMovie.movieBooking.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingID;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "TheatreId")
    private Integer theatreId;

    @Column(name = "NumberOfTickets")
    private Integer numberOfTickets;

    @Column(name = "TotalAmount")
    private BigDecimal totalAmount;

    @Column(name = "BookingDate")
    private Date bookingDate;

    @Column(name = "Status")
    private boolean status;

    // Getters and setters

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Integer theatreId) {
        this.theatreId = theatreId;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public Booking() {
    }

    // Constructor with parameters
    public Booking(Integer userID, Integer theatreId, Integer numberOfTickets, BigDecimal totalAmount, Date bookingDate, boolean status) {
        this.userID = userID;
        this.theatreId = theatreId;
        this.numberOfTickets = numberOfTickets;
        this.totalAmount = totalAmount;
        this.bookingDate = bookingDate;
        this.status = status;
    }
    @Override
	public String toString() {
		return "Booking [userID=" + userID + ", theatreId=" + theatreId + ", numberOfTickets=" + numberOfTickets
				+ ", totalAmount=" + totalAmount + ",bookingDate=" +bookingDate +",status="+ status +"]";
	}
}
