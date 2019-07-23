package com.contasapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.contasapp.models.Bill;
import com.contasapp.models.Payment;

public interface IBillRepository extends CrudRepository<Bill, String>{
	Iterable<Bill> findByPayment(Payment payment);
}
