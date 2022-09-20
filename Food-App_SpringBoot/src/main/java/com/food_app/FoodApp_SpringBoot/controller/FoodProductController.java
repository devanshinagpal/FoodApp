package com.food_app.FoodApp_SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food_app.FoodApp_SpringBoot.dto.FoodProduct;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;
import com.food_app.FoodApp_SpringBoot.service.FoodProductService;

@RestController
@CrossOrigin
public class FoodProductController {

	@Autowired
	FoodProductService foodProductService;
	
	@PostMapping("/foodProducts")
	public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.saveFoodProduct(foodProduct);
	}
	
	@PutMapping("/foodProducts")
	public ResponseEntity<ResponseStructure<FoodProduct>> updateFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.updateFoodProduct(foodProduct);
	}
	
	@GetMapping("/foodProducts")
	public ResponseEntity<ResponseStructure<List<FoodProduct>>> getAllfFoodProducts(){
		return foodProductService.getAllFoodProducts();
	}
	
	@GetMapping("/foodProduct/{id}")
	public ResponseEntity<ResponseStructure<FoodProduct>> getProductById(@PathVariable int id) {
		return foodProductService.getProductById(id);
	}
	
	@DeleteMapping("/foodProduct/{id}")
	public ResponseEntity<ResponseStructure<FoodProduct>> deleteFoodProduct(@PathVariable int id) {
		return foodProductService.deleteFoodProduct(id);
	}

}
