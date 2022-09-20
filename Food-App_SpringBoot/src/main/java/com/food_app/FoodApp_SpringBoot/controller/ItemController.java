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

import com.food_app.FoodApp_SpringBoot.dto.Item;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;
import com.food_app.FoodApp_SpringBoot.service.ItemService;


@RestController
@CrossOrigin
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping("/additems")
	public ResponseEntity<ResponseStructure<Item>> saveItems(@RequestBody Item item) {
		return itemService.saveItems(item);
	}
	@PutMapping("/updateitems")
	public ResponseEntity<ResponseStructure<Item>> updateFoodProduct(@RequestBody Item item) {
		return itemService.updateItems(item);
	}
	
	@GetMapping("/getitems")
	public ResponseEntity<ResponseStructure<List<Item>>> getAllFoodProducts(){
		return itemService.getAllItems();
	}
	
	@GetMapping("/getitems/{id}")
	public ResponseEntity<ResponseStructure<Item>> getProductById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@DeleteMapping("/deleteitems/{id}")
	public ResponseEntity<ResponseStructure<Item>> deleteFoodProduct(@PathVariable int id) {
		return itemService.deleteItem(id);
	}

    
   
}
