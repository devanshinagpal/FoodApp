package com.food_app.FoodApp_SpringBoot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food_app.FoodApp_SpringBoot.dto.User;
import com.food_app.FoodApp_SpringBoot.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) { 
		return userRepository.save(user); 
	} 
	
	public List<User> getAllUsers() { 
		return userRepository.findAll();
	} 
	
	public User updateUser(User updated_user,int id) {
		User user = getUserById(id);
		user.setName(updated_user.getName());
        user.setPassword(updated_user.getPassword());
        user.setRole(updated_user.getRole());
		return userRepository.save(user);
	}
	
	public User getUserById(int id) { 
		return userRepository.findById(id).get();
	} 
	
	public void deleteUser(int id) { 
		if(userRepository.existsById(id)) {
		userRepository.deleteById(id);
		}
	}
	public User findByEmail(String email) {	
		User user=userRepository.findByEmail(email);
		return user;
	}
	public User userLogin(User user) {
		User check=findByEmail(user.getEmail());
        if(check==null)
            return check;
        if(check.getPassword().equals(user.getPassword()))
            return check;
        return null;
	}
}