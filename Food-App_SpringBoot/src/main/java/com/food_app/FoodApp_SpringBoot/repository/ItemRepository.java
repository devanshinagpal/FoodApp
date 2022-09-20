package com.food_app.FoodApp_SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_app.FoodApp_SpringBoot.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
