package com.contasapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.contasapp.models.Bill;
import com.contasapp.models.Payment;

public interface IBillRepository extends CrudRepository<Bill, String> {
	Iterable<Bill> findByPayment(Payment payment);

	@Modifying
	@Transactional
	@Query(value = ("DELETE FROM bill WHERE code_bill = ?1"), nativeQuery = true)
	public void deleteById(long id);
	
	Bill findByCodeBill(long id);
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 */
	//@Query(value = ("SELECT FROM bill WHERE payment_id = ?1"), nativeQuery = true)
	List<Bill> findListByPayment(Payment payment);

}
