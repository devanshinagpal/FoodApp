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

import com.food_app.FoodApp_SpringBoot.dto.FoodOrder;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;
import com.food_app.FoodApp_SpringBoot.service.FoodOrderService;

@RestController
@CrossOrigin
public class FoodOrderController {

	@Autowired
	FoodOrderService foodOrderService;
	
	@PostMapping("/order")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveOrder(foodOrder);
	}
	@PutMapping("/editorder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.updateOrder(foodOrder);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> getAllOrders(){
		return foodOrderService.getAllOrders();
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> getProductById(@PathVariable int id) {
		return foodOrderService.getOrderById(id);
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodProduct(@PathVariable int id) {
		return foodOrderService.deleteOrder(id);
	}

}
