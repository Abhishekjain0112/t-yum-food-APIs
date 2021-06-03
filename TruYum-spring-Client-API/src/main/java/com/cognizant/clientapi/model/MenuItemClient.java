package com.cognizant.clientapi.model;

import java.time.LocalDate;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MenuItemClient {

	private long id;

	private String name;
	
	private double price;
	
	private boolean active;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfLaunch;
	
	private String category;

	private boolean freeDelivery;
	

	
	
}
