package com.food_app.FoodApp_SpringBoot.dto;
// Order 
import java.time.LocalDateTime;
//import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String status;
	private double totalPrice;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime orderCreatedTime;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime deliveryCreatedTime;
	
	private String customerName;
	private String customerNumber;
	
//	@OneToMany(cascade=CascadeType.ALL,mappedBy = "foodOrder")
//	@JsonIgnore
//	private List<Item> items;
	
//	public List<Item> getItems() {
//		return items;
//	}
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getOrderCreatedTime() {
		return orderCreatedTime;
	}
	public void setOrderCreatedTime(LocalDateTime orderCreatedTime) {
		this.orderCreatedTime = orderCreatedTime;
	}
	public LocalDateTime getDeliveryCreatedTime() {
		return deliveryCreatedTime;
	}
	public void setDeliveryCreatedTime(LocalDateTime deliveryCreatedTime) {
		this.deliveryCreatedTime = deliveryCreatedTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
}
