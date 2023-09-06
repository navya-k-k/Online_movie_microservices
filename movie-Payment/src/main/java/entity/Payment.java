package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PaymentId;
    private Integer UserId;
    private Integer BookingId;
    private String PaymentType;
    private Date PaymentDate;
    private boolean Status;
    
    
	public Payment(Integer paymentId, Integer userId, Integer bookingId, String paymentType, Date paymentDate,
			boolean status) {
		super();
		PaymentId = paymentId;
		UserId = userId;
		BookingId = bookingId;
		PaymentType = paymentType;
		PaymentDate = paymentDate;
		Status = status;
	}
	
	public Integer getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(Integer paymentId) {
		PaymentId = paymentId;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public Integer getBookingId() {
		return BookingId;
	}
	public void setBookingId(Integer bookingId) {
		BookingId = bookingId;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public Date getPaymentDate() {
		return PaymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		PaymentDate = paymentDate;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
  
}

