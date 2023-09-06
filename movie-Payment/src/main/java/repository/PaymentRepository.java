package repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	List<Payment> findByUserId(Integer userId);

    List<Payment> findByPaymentType(String paymentType);
}
