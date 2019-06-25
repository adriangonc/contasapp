package com.contasapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {

	@RequestMapping("/createPayment")
	public String form() {
		return "payment/formPayment";
	}

}
