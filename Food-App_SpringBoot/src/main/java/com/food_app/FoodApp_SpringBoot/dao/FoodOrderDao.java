package com.food_app.FoodApp_SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food_app.FoodApp_SpringBoot.dto.FoodOrder;
import com.food_app.FoodApp_SpringBoot.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepository foodOrderRepository;
	
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder); 
		} 
	
	public List<FoodOrder> getAllOrders() { 
		return foodOrderRepository.findAll();
		} 
	
	public FoodOrder updateOrder(FoodOrder foodOrder) {
		return foodOrderRepository.saveAndFlush(foodOrder);
	}
	
	public Optional<FoodOrder> getOrderById(int id) { 
		return foodOrderRepository.findById(id);
		} 
	
	public void deleteOrder(int id) { 
		if(foodOrderRepository.existsById(id)) {
		foodOrderRepository.deleteById(id);
	}
	}
}