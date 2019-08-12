package com.contasapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contasapp.models.Bill;
import com.contasapp.models.Payment;
import com.contasapp.repository.IBillRepository;
import com.contasapp.repository.IPaymentRepository;

@Controller
public class PaymentController {

	@Autowired
	private IPaymentRepository pr;

	@Autowired
	private IBillRepository br;

	@RequestMapping(value = "/createPayment", method = RequestMethod.GET)
	public String form() {
		return "payment/formPayment";
	}

	@RequestMapping(value = "/createPayment", method = RequestMethod.POST)
	public String form(Payment payment) {
		pr.save(payment);
		return "redirect:/createPayment";
	}

	@RequestMapping("/payments")
	public ModelAndView listPayments() {
		ModelAndView mv = new ModelAndView("/listPayments");
		Iterable<Payment> payments = pr.findAll();
		double totalaValue = 0;
		for (Payment payment : payments) {
			totalaValue = 0;
			for (Bill bill : br.findByPayment(payment)) {
				totalaValue += bill.getValue();
			}
			payment.setTotal(totalaValue);
			
		}
		//List<Double> values = new br.findByPayment(payment);
		
		mv.addObject("payments", payments);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView paymetDetails(@PathVariable("id") long id) {
		Payment payment = pr.findById(id);
		ModelAndView mv = new ModelAndView("payment/paymentDetail");
		mv.addObject("payment", payment);

		Iterable<Bill> bills = br.findByPayment(payment);
		mv.addObject("bills", bills);

		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String saveBill(@PathVariable("id") long id, @Valid Bill bill, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos digitados!");
			return "redirect:/{id}";
		}
		Payment payment = pr.findById(id);
		bill.setPayment(payment);
		bill.setPaymentCode(payment.getId());
		bill.setId(null);
		br.save(bill);
		attributes.addFlashAttribute("mensagem", "Conta adicionada com sucesso!");
		return "redirect:/{id}";
	}
	
	@RequestMapping("/deletePayment")
	public String deletePayment(Long code) {
		pr.deleteById(code);		
		return "redirect:/payments";
	}
	
	@RequestMapping("/deleteBill")
	public String deleteBill(Long code) {
		Bill bill = br.findByCodeBill(code);
		Payment payment = bill.getPayment();
		br.deleteById(code);
		return "redirect:/" + payment.getId().toString();
	}
	
	

}
