//package com.food_app.FoodApp_SpringBoot.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.food_app.FoodApp_SpringBoot.dto.User;
//import com.food_app.FoodApp_SpringBoot.models.UserDetailsImpl;
//import com.food_app.FoodApp_SpringBoot.repository.UserRepository;
//
//
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		User user=userRepository.findByEmail(username);
//		
//		if(user==null) {
//			System.out.println("exception thrown");
//			throw new UsernameNotFoundException(username + "not found");
//		}
//		return new UserDetailsImpl(user);
//	}
//
//}
