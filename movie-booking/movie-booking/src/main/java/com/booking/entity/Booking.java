package com.booking.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
    private Integer bookingId;
	@Column(name = "userid")
	private Integer userID;
	@Column(name ="theatre_id")
	 private Integer theatreId;
	@Column(name = "number_of_tickets")
	 private Integer numberOfTickets;
	@Column(name = "total_amount")
	    private BigDecimal totalAmount;
	@Column(name = "booking_date")
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


		public Booking() {
			super();
		}


		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", userID=" + userID + ", theatreId=" + theatreId
					+ ", numberOfTickets=" + numberOfTickets + ", totalAmount=" + totalAmount + ", bookingDate="
					+ bookingDate + ", status=" + status + "]";
		}


		
}
