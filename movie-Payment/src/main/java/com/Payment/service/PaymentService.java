package com.Payment.service;

import java.util.List;

import com.Payment.entity.Payment;

public interface PaymentService {
	
	public Payment addPayment(Payment payment);
	public List<Payment> getAllPayment();
	public Payment getPaymentById (Integer id);

	
}
