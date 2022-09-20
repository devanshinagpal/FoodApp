package com.food_app.FoodApp_SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food_app.FoodApp_SpringBoot.dao.MenuDao;
import com.food_app.FoodApp_SpringBoot.dto.Menu;
import com.food_app.FoodApp_SpringBoot.dto.User;
import com.food_app.FoodApp_SpringBoot.exception.IdNotFoundException;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	MenuDao menuDao;
	@Autowired
	UserService userService;
	
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		User user=new User();
		menu.setUser(user);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>(); 
		responseStructure.setMessage("Success");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(menuDao.addMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
	}
	public ResponseEntity<ResponseStructure<List<Menu>>> getMenu(){
		ResponseStructure<List<Menu>> responseStructure=new ResponseStructure<List<Menu>>(); 
		responseStructure.setMessage("Success");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(menuDao.getMenu());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure,HttpStatus.OK);
		
	}
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		Optional<Menu> optional=menuDao.getMenuById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>(); 
			responseStructure.setMessage("Success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		} 
	}
	
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int id) { 
		Optional<Menu> optional=menuDao.getMenuById(id);
		if(optional.isEmpty()) { 
			throw new IdNotFoundException("No such Id "+id+"is present");
		} 
		else {
			menuDao.deleteMenu(id);
			ResponseStructure<Menu> responseStructure=new ResponseStructure<Menu>(); 
			responseStructure.setMessage("Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(null);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure,HttpStatus.OK);
		} 
	}
}
