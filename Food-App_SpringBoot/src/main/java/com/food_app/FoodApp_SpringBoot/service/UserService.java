package com.food_app.FoodApp_SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.food_app.FoodApp_SpringBoot.dao.UserDao;
import com.food_app.FoodApp_SpringBoot.dto.User;
import com.food_app.FoodApp_SpringBoot.exception.IdNotFoundException;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User retrievedUser=userDao.getUserById(id);
		if(retrievedUser==null) {
				throw new IdNotFoundException("User Id not found");
		}
		else {
			ResponseStructure<User> responseStructure=new ResponseStructure<User>(); 
			responseStructure.setMessage("Success");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(userDao.getUserById(id));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		}
	}
	
	public User findByEmail(String email) {	
		return userDao.findByEmail(email);
	}
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure=new ResponseStructure<User>(); 
		responseStructure.setMessage("Success");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(userDao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}
	
	public User updateUser(int id,User user) {
		User retrievedUser=userDao.getUserById(id);
		if(retrievedUser==null)
			try {
				throw new IdNotFoundException("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		userDao.saveUser(user);
		return userDao.getUserById(id);	
	}
	
	public User deleteUser(int id) {
		User retrievedUser=userDao.getUserById(id);
		if(retrievedUser==null)
			try {
				throw new Exception("User not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		userDao.deleteUser(id);
		return retrievedUser;
	}
	public User userLogin(User user) {
		return userDao.userLogin(user);
	}
}
