package com.food_app.FoodApp_SpringBoot.response;

public class ResponseStructure<Data> {

	private String message;
	private int status;
	private Data data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data string) {
		this.data = string;
	}
}
