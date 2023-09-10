package com.booking.entity;

import java.math.BigDecimal;
import java.sql.Date;

//import javax.persistence.Column;

public class Booking {
	private Integer bookingId;
	private Integer userID;
	 private Integer theatreId;
	 private Integer numberOfTickets;
	 private BigDecimal totalAmount;
	    private Date bookingDate;
	    private boolean status;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
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
	public Booking(Integer bookingId, Integer userID, Integer theatreId, Integer numberOfTickets,
			BigDecimal totalAmount, Date bookingDate, boolean status) {
		super();
		this.bookingId = bookingId;
		this.userID = userID;
		this.theatreId = theatreId;
		this.numberOfTickets = numberOfTickets;
		this.totalAmount = totalAmount;
		this.bookingDate = bookingDate;
		this.status = status;
	}
	
	    
	 }
		
		
		
