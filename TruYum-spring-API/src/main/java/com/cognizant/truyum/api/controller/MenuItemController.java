package com.cognizant.truyum.api.controller;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.api.model.MenuItem;
import com.cognizant.truyum.api.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	
	
	@Autowired
	MenuItemService menuItemService;
	
	@PostConstruct
	public void addData() {
		
		MenuItem menuItem1 = new MenuItem(1, "Sandwich", 99, true,LocalDate.of(2017, 03, 15) ,"Main Course", true);
		MenuItem menuItem2 = new MenuItem(2, "Burger", 129, true, LocalDate.of(2017, 12, 12),"Main Course", false);
		MenuItem menuItem3 = new MenuItem(3, "Pizza", 149, true, LocalDate.of(2018, 8, 21),"Main Course", false);
		MenuItem menuItem4 = new MenuItem(4, "French Fries", 57, false,LocalDate.of(2017, 7, 23),"Starters", true);
		MenuItem menuItem5 = new MenuItem(5, "Chocolate Brownie", 32, true, LocalDate.of(2022, 11, 2),"Dessert", true);
		menuItemService.saveMenuItem(menuItem1);
		menuItemService.saveMenuItem(menuItem2);
		menuItemService.saveMenuItem(menuItem3);
		menuItemService.saveMenuItem(menuItem4);
		menuItemService.saveMenuItem(menuItem5);
		
	}
	
	
	
	@GetMapping("/pizza")
	public MenuItem getPizza() {
		return new MenuItem(3, "Pizza", 149, true, LocalDate.of(2018, 8, 21),"Main Course", false);
	}
	

	@GetMapping("/id/{id}")
	public MenuItem getMenuItem(@PathVariable long id) {
		return menuItemService.getMenuItem(id);
	}
	
	@GetMapping("/items")
	public List<MenuItem> getMenuItems() {
		return menuItemService.getMenuItemListAdmin();
	}
	
	@PutMapping("/item/update")
	 public MenuItem modifyMenuItem(@RequestBody @Valid MenuItem menuItem) {
          menuItemService.editMenuItem(menuItem);
          return menuItem;
	 }

	
	@PutMapping("/item/add")
	 public MenuItem addMenuItem(@RequestBody  @Valid MenuItem menuItem) {
         menuItemService.addMenuItem(menuItem);
         return menuItem;
	 }	
	
	@DeleteMapping("/remove/{menuItemId}")
	public MenuItem deletMenuItem(@PathVariable long menuItemId) {
		return menuItemService.deleteMenuItem(menuItemId);
	}
	
}




/*
 * 
 * {
    "id": 3,
    "name": "Pizza",
    "price": 149.0,
    "active": true,
    "dateOfLaunch": "2018-08-21",
    "category": "Main Course",
    "freeDelivery": false
}
 * 
 * */
 