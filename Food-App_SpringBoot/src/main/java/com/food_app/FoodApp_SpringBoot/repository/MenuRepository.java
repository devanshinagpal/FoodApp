package com.food_app.FoodApp_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_app.FoodApp_SpringBoot.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

	
}
