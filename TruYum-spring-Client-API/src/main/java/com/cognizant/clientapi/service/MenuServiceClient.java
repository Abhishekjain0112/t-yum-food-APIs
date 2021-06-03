package com.cognizant.clientapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cognizant.clientapi.model.MenuItemClient;

@Service
public class MenuServiceClient {

	
	RestTemplate restTemplate= new RestTemplate();
	
	
	public MenuItemClient getMenuItem(long id) {
		MenuItemClient menuItem= restTemplate.getForObject("http://localhost:8080/menu-items/id/"+id, MenuItemClient.class);
		return menuItem;		
	}
	
}
