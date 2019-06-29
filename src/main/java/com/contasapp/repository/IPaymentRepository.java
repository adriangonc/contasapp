package com.contasapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.contasapp.models.Payment;

public interface IPaymentRepository extends CrudRepository<Payment, String>{

}
