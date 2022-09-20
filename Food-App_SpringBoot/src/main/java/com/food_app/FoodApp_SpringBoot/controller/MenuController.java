package com.food_app.FoodApp_SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food_app.FoodApp_SpringBoot.dto.Menu;
import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;
import com.food_app.FoodApp_SpringBoot.service.MenuService;
import com.food_app.FoodApp_SpringBoot.service.UserService;

@RestController
@CrossOrigin
public class MenuController {

	@Autowired
	MenuService menuService;
	@Autowired
	UserService userService;
	
	@PostMapping("/addmenu/{user_id}")
	public ResponseEntity<ResponseStructure<Menu>> addMenu(@RequestBody Menu menu,@PathVariable int user_id) { 
	    return menuService.saveMenu(menu);
	}
	@GetMapping("/menus")
	public ResponseEntity<ResponseStructure<List<Menu>>> getAllMenus(){
		return menuService.getMenu();
	}
	
//	@GetMapping("/menu/{user_id}")
//	public ResponseEntity<ResponseStructure<Menu>> getMenuByUserId(@PathVariable int user_id) {
//		return userService.getUserById(user_id).getMenu();
//	}
	    
    @DeleteMapping("/deletemenu/{id}")
    public void deleteMenu(@PathVariable int id){
    	menuService.deleteMenu(id);

    }
}
