package com.Payment.entity;


import java.sql.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	

			    @Id
			    @GeneratedValue(strategy = GenerationType.IDENTITY)
			    private Integer paymentId;
			    private Integer userId;
			    private Integer bookingId;
			    private String paymentType;
			    private Date paymentDate;
			    private boolean status;
			    
			    
				public Integer getPaymentId() {
					return paymentId;
				}
				public void setPaymentId(Integer paymentId) {
					this.paymentId = paymentId;
				}
				public Integer getUserId() {
					return userId;
				}
				public void setUserId(Integer userId) {
					this.userId = userId;
				}
				public Integer getBookingId() {
					return bookingId;
				}
				public void setBookingId(Integer bookingId) {
					this.bookingId = bookingId;
				}
				public String getPaymentType() {
					return paymentType;
				}
				public void setPaymentType(String paymentType) {
					this.paymentType = paymentType;
				}
				public Date getPaymentDate() {
					return paymentDate;
				}
				public void setPaymentDate(Date paymentDate) {
					this.paymentDate = paymentDate;
				}
				public boolean isStatus() {
					return status;
				}
				public void setStatus(boolean status) {
					this.status = status;
				}
				
				
				public Payment(Integer paymentId,Integer userId, Integer bookingId, String paymentType,Date paymentDate,boolean status)
			   
			    {
					super();
					this.paymentId = paymentId;
					this. userId =  userId;
					this. bookingId=  bookingId;
					this.paymentType = paymentType;
					this.paymentDate= paymentDate;
					this.status = status;
					
				}
				@Override
				public String toString() {
					return "Payment [paymentId=" + paymentId + ", userId=" + userId + ", bookingId=" + bookingId
							+ ", paymentType=" + paymentType + ", paymentDate=" + paymentDate + ", status=" + status
							+ "]";
				}

			    

			}
