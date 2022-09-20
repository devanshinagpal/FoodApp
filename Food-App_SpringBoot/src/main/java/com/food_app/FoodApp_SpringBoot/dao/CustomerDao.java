package com.food_app.FoodApp_SpringBoot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food_app.FoodApp_SpringBoot.dto.Customer;
import com.food_app.FoodApp_SpringBoot.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}
