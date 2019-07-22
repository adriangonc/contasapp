package com.contasapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.contasapp.models.Bill;

public interface IBillRepository extends CrudRepository<Bill, String>{

}
