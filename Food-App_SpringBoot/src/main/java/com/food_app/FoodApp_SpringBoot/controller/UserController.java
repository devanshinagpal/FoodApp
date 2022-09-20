package com.food_app.FoodApp_SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food_app.FoodApp_SpringBoot.dto.Menu;
import com.food_app.FoodApp_SpringBoot.dto.User;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;
import com.food_app.FoodApp_SpringBoot.service.UserService;

@RestController
@CrossOrigin
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	MenuController menuController;
	
//	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/loginuser")
	public User userLogin(@RequestBody User user){
		return userService.userLogin(user);
	}
		
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
//		System.out.println(user.getEmail()+"  "+auth.getName());
		 Menu menu=new Menu();
		 menuController.addMenu(menu, user.getId());
		return userService.saveUser(user);
		
	}
	
//	@PreAuthorize("@userSecurity.hasId(authentication,#id)")
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable("id") int id) {
		System.out.println("Inside getuserbyid method");
		return userService.getUserById(id);
		
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") int id,@RequestBody User user) {
		return ResponseEntity.ok().body(userService.updateUser(id,user));
		
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
		 userService.deleteUser(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}
	
//	@GetMapping("/users/search")
//	@PostAuthorize("returnObject.body.name==authenticated.user")
//	public ResponseEntity<User> userDetails(Authentication authentication, @RequestParam("email") String email) throws Exception {
//		System.out.println(authentication.getName().toString());
//		User User=userService.findByEmail(email);
//		if(User==null) {
//			ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//		}
//		return ResponseEntity.ok().body(User);
//		
//	}
}


