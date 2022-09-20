//package com.food_app.FoodApp_SpringBoot.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import com.food_app.FoodApp_SpringBoot.repository.UserRepository;
//
//@Component("userSecurity")
//public class UserSecurity {
//
//	@Autowired
//	UserRepository userRepository;
//	
//public boolean hasUserId(Authentication authentication, Integer userId) {
//		
//		int userID=userRepository.findByEmail(authentication.getName()).getId();
////		System.out.println(userId+"  "+userID);
//            if(userID==userId)
//            	return true;
//            
//            return false;
//       
//    }
//}
