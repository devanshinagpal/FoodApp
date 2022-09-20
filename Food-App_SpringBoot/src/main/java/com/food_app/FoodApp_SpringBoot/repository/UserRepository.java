package com.food_app.FoodApp_SpringBoot.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food_app.FoodApp_SpringBoot.dto.User;


public interface UserRepository extends JpaRepository<User, Integer>{

//	public List<User> getUsers();
	public User findByEmail(String email);
}
