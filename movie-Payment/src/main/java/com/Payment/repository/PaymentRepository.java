package com.Payment.repository;

//import java.sql.Date;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payment.entity.Payment;

@Repository(value="paymentRepository")
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
}
