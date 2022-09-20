package com.food_app.FoodApp_SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food_app.FoodApp_SpringBoot.dao.CustomerDao;
import com.food_app.FoodApp_SpringBoot.dto.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}  
	
}
