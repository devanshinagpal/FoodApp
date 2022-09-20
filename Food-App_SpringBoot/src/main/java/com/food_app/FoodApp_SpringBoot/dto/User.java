package com.food_app.FoodApp_SpringBoot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@JsonIgnoreType
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;  //Staff,BranchManager, Admin
	
	@OneToMany(mappedBy="user")
	private List<FoodOrder> foodOrder;
	
	@OneToOne
	private Menu menu;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		
	}
	public User(int id, String name, String email, String password, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public List<FoodOrder> getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(List<FoodOrder> foodOrder) {
		this.foodOrder = foodOrder;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
//	@Override
//	public int hashCode() {
//		
//		return this.id;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		
//		
//		if(obj==null || !(obj instanceof User) )
//			return false;
//		return this.id==((User)obj).getId();
//	}
	
}
