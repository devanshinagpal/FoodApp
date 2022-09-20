package com.food_app.FoodApp_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food_app.FoodApp_SpringBoot.dao.FoodProductDao;
import com.food_app.FoodApp_SpringBoot.dto.FoodProduct;
import com.food_app.FoodApp_SpringBoot.dto.Menu;
import com.food_app.FoodApp_SpringBoot.exception.IdNotFoundException;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;

@Service
public class FoodProductService {

	@Autowired
	FoodProductDao foodProductDao;
	
	public ResponseEntity<ResponseStructure<FoodProduct>> saveFoodProduct(FoodProduct foodProduct) {
		Menu menu = new Menu();
		foodProduct.setMenu(menu);
		ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<FoodProduct>();
		responseStructure.setMessage("Added Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(foodProductDao.saveFoodProduct(foodProduct));
		return new ResponseEntity<ResponseStructure<FoodProduct>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<FoodProduct>> updateFoodProduct(FoodProduct foodProduct) {
		ResponseStructure<FoodProduct> responseStructure = new ResponseStructure<FoodProduct>();
		responseStructure.setMessage("Added Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(foodProductDao.updateFoodProduct(foodProduct));
		return new ResponseEntity<ResponseStructure<FoodProduct>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<FoodProduct>>> getAllFoodProducts(){
		ResponseStructure<List<FoodProduct>> responseStructure = new ResponseStructure<List<FoodProduct>>();
		responseStructure.setMessage("Added Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(foodProductDao.getAllFoodProducts());
		return new ResponseEntity<ResponseStructure<List<FoodProduct>>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<FoodProduct>> getProductById(int id) {
		Optional<FoodProduct> optional=foodProductDao.getProductById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			ResponseStructure<FoodProduct> responseStructure=new ResponseStructure<FoodProduct>(); 
			responseStructure.setMessage("Success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<FoodProduct>>(responseStructure,HttpStatus.OK);
		} 
	}
	public ResponseEntity<ResponseStructure<FoodProduct>> deleteFoodProduct(int id) {
		Optional<FoodProduct> optional=foodProductDao.getProductById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			foodProductDao.deleteFoodProduct(id);
			ResponseStructure<FoodProduct> responseStructure=new ResponseStructure<FoodProduct>(); 
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<FoodProduct>>(responseStructure,HttpStatus.OK);
		} 
	}

}
