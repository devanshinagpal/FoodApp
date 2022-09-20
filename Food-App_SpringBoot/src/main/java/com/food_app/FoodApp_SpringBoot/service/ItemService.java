package com.food_app.FoodApp_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food_app.FoodApp_SpringBoot.dao.ItemDao;
import com.food_app.FoodApp_SpringBoot.dto.Item;
import com.food_app.FoodApp_SpringBoot.exception.IdNotFoundException;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;


@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	public ResponseEntity<ResponseStructure<Item>> saveItems(Item item) {
		ResponseStructure<Item> responseStructure=new ResponseStructure<Item>(); 
		responseStructure.setMessage("Success");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(itemDao.saveItems(item));
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Item>> updateItems(Item item) {
		ResponseStructure<Item> responseStructure=new ResponseStructure<Item>(); 
		responseStructure.setMessage("Success");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(itemDao.updateItems(item));
		return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Item>>> getAllItems(){
		ResponseStructure<List<Item>> responseStructure=new ResponseStructure<List<Item>>(); 
		responseStructure.setMessage("Success");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(itemDao.getAllItems());
		return new ResponseEntity<ResponseStructure<List<Item>>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Item>> getItemById(int id) { 
		Optional<Item> optional=itemDao.getItemById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			ResponseStructure<Item> responseStructure=new ResponseStructure<Item>(); 
			responseStructure.setMessage("Success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);
		} 
	}
	
	public ResponseEntity<ResponseStructure<Item>> deleteItem(int id) { 
		Optional<Item> optional=itemDao.getItemById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			itemDao.deleteItem(id);
			ResponseStructure<Item> responseStructure=new ResponseStructure<Item>(); 
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);
		} 
	}

}
