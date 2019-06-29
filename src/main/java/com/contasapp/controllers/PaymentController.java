package com.contasapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.contasapp.models.Payment;
import com.contasapp.repository.IPaymentRepository;

@Controller
public class PaymentController {

	@Autowired
	private IPaymentRepository pr;
	
	@RequestMapping(value="/createPayment", method = RequestMethod.GET)
	public String form() {
		return "payment/formPayment";
	}
	
	@RequestMapping(value="/createPayment", method = RequestMethod.POST)
	public String form(Payment payment) {
		pr.save(payment);
		return "redirect:/createPayment";
	}

}
