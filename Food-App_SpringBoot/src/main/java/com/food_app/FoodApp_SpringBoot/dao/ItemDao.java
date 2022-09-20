package com.food_app.FoodApp_SpringBoot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food_app.FoodApp_SpringBoot.dto.Item;
import com.food_app.FoodApp_SpringBoot.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	private ItemRepository itemRepository;
	
	public Item saveItems(Item item) {
		return itemRepository.save(item);
	}
	
	public Item updateItems(Item item) {
		return itemRepository.saveAndFlush(item);
	}
	
	public List<Item> getAllItems(){
		return itemRepository.findAll();
	}
	
	public Optional<Item> getItemById(int id) { 
		return itemRepository.findById(id);
	}
	
	public void deleteItem(int id) { 
		if(itemRepository.existsById(id)) { 
			itemRepository.deleteById(id);
		}	
		}
	
}
