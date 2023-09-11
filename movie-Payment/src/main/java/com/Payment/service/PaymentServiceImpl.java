package com.Payment.service;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.Payment.entity.Payment;
import com.Payment.repository.PaymentRepository;

@Service
@Scope(value ="singleton")
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}


	@Override
	public List<Payment> getAllPayment() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getPaymentById(Integer id) {
		return paymentRepository.findById(id).get();
	}


	
	

}
