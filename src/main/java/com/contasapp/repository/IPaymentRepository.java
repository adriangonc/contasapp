package com.contasapp.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.contasapp.models.Payment;

public interface IPaymentRepository extends CrudRepository<Payment, String>{
	Payment findById(long id);
	
	@Modifying
	@Transactional
	@Query(value=("DELETE FROM payment WHERE id = ?1"), 
			nativeQuery = true)
	public void deleteById(long id);
}
