package com.food_app.FoodApp_SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food_app.FoodApp_SpringBoot.dto.Menu;
import com.food_app.FoodApp_SpringBoot.repository.MenuRepository;

@Repository
public class MenuDao {
	
	@Autowired
	MenuRepository menuRepository;

	public Menu addMenu(Menu menu){
		return menuRepository.save(menu);
	}
	public void deleteMenu(int id) { 
		if(menuRepository.existsById(id)) { 
			menuRepository.deleteById(id);
		}	
	}
	public List<Menu> getMenu(){
		return menuRepository.findAll();
	}
	public Optional<Menu> getMenuById(int id) { 
		return menuRepository.findById(id);
		
	  } 
}
