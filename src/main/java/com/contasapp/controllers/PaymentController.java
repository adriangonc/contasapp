package com.contasapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/payments")
	public ModelAndView listPayments() {
		ModelAndView mv = new ModelAndView("/index");
		Iterable<Payment> payments = pr.findAll();
		mv.addObject("payments", payments);
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView paymetDetails(@PathVariable("id") long id) {
		Payment payment = pr.findById(id);
		ModelAndView mv = new ModelAndView("payment/paymentDetail");
		mv.addObject("payment", payment);
		return mv;
	}
	
}
