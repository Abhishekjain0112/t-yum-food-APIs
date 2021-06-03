package com.cognizant.clientapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.clientapi.model.MenuItemClient;
import com.cognizant.clientapi.service.MenuServiceClient;

@RestController
@RequestMapping("/client-menu")
public class MenuItemClientController {
	
	@Autowired
	private MenuServiceClient menuServiceClient;
		
	  @GetMapping("/id")
	  public MenuItemClient getTest() {
		  return new MenuItemClient();
	  }

	  
	  @GetMapping("/id/{id}")
	  public MenuItemClient getMenuItem(@PathVariable long id) {
		  return menuServiceClient.getMenuItem(id);
	  }	  
	  
	
}
