package com.food_app.FoodApp_SpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.food_app.FoodApp_SpringBoot.response.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> IdNotFoundException(IdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setMessage("Not Found");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ex.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		
	}
	
	
	
	
}
