package com.Payment.controller;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Payment.entity.Payment;
import com.Payment.service.PaymentService;

@RestController
@Scope(value = "request")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	//private Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@PostMapping(value = "/payment", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public Payment addPayment(@RequestBody Payment payment) {
		//log.debug("Received a request to add a Payment: " + Payment);
		Payment addedPayment = paymentService.addPayment(payment);
		//log.info("Payment added: ", addedPayment);
		return addedPayment;
	}
	
	
	@GetMapping(value = "/payment/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Payment getPaymentById(@PathVariable("id") Integer id) {
		//log.debug("Received a request to get a movie with id: " + id);
		Payment paymentById = paymentService.getPaymentById(id);
		//log.info("Return Value: ", PaymentById);
		return paymentById;
	}
	
	
	@GetMapping(value = "/payment", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Payment> getAllpayment() {
		//log.debug("Received a request to view all Payment");
		 List<Payment> allPayment = paymentService.getAllPayment();
		 //log.info("All Payment Return Value: " + allPayment);
		 return allPayment;
		
	}
	
	
	

}
