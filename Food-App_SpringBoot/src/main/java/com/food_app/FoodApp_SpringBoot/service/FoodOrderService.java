package com.food_app.FoodApp_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food_app.FoodApp_SpringBoot.dao.FoodOrderDao;
import com.food_app.FoodApp_SpringBoot.dto.FoodOrder;
import com.food_app.FoodApp_SpringBoot.exception.IdNotFoundException;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao foodOrderDao;
	
	public ResponseEntity<ResponseStructure<FoodOrder>> saveOrder(FoodOrder foodOrder) { 
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		responseStructure.setMessage("Added Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(foodOrderDao.saveOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} 
	
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> getAllOrders() { 
		ResponseStructure<List<FoodOrder>> responseStructure = new ResponseStructure<List<FoodOrder>>();
		responseStructure.setMessage("Added Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(foodOrderDao.getAllOrders());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(responseStructure,HttpStatus.OK);
		} 
	
	public ResponseEntity<ResponseStructure<FoodOrder>> updateOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<FoodOrder>();
		responseStructure.setMessage("Added Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(foodOrderDao.updateOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getOrderById(int id) { 
		Optional<FoodOrder> optional=foodOrderDao.getOrderById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>(); 
			responseStructure.setMessage("Success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} 
		} 
	
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteOrder(int id) {
		Optional<FoodOrder> optional=foodOrderDao.getOrderById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			foodOrderDao.deleteOrder(id);
			ResponseStructure<FoodOrder> responseStructure=new ResponseStructure<FoodOrder>(); 
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure,HttpStatus.OK);
		} 
	}
}
                                                                                 