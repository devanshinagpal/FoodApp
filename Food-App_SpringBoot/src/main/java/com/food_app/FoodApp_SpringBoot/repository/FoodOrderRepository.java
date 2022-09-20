package com.food_app.FoodApp_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_app.FoodApp_SpringBoot.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {
	
	

}
