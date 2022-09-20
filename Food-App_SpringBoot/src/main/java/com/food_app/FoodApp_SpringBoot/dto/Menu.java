package com.food_app.FoodApp_SpringBoot.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy = "menu")
	@JsonIgnore
	private List<FoodProduct> foodProduct;
	
	@OneToOne
	@JoinColumn
	private User user;
	
	public Menu() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<FoodProduct> getFoodProduct() {
		return foodProduct;
	}

	public void setFoodProduct(List<FoodProduct> foodProduct) {
		this.foodProduct = foodProduct;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
