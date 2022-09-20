package com.food_app.FoodApp_SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food_app.FoodApp_SpringBoot.dto.FoodProduct;
import com.food_app.FoodApp_SpringBoot.dto.Menu;
import com.food_app.FoodApp_SpringBoot.repository.FoodProductRepository;
import com.food_app.FoodApp_SpringBoot.repository.MenuRepository;


@Repository
public class FoodProductDao {

	@Autowired
	FoodProductRepository foodProductRepository;
	@Autowired
	MenuRepository menuRepository;
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		Menu menu = new Menu(); 
		menuRepository.save(menu);
		foodProduct.setMenu(menu);
		return foodProductRepository.save(foodProduct);
	}
	
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
	
	public List<FoodProduct> getAllFoodProducts(){
		return foodProductRepository.findAll();
	}
	
	public Optional<FoodProduct> getProductById(int id) { 
		return foodProductRepository.findById(id);
	}
	public void deleteFoodProduct(int id) { 
		if(foodProductRepository.existsById(id)) {
			foodProductRepository.deleteById(id);
		}
	}
}
