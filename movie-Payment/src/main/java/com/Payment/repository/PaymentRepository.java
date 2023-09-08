package com.Payment.repository;

//import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Payment.entity.Payment;

@Repository(value=" PaymentRepository")
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	Payment save(Payment payment);
	Optional<Payment> findById(Integer id);
	List<Payment> findAll();
}
