package com.cognizant.truyum.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.api.dao.MenuItemDao;
import com.cognizant.truyum.api.exception.MenuItemNotFound;
import com.cognizant.truyum.api.model.MenuItem;


@Service("menuItemService")
public class MenuItemService {

	@Autowired
	MenuItemDao menuItemDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);
	
	
	@Transactional
	public void saveMenuItem(MenuItem menuItem) {
		LOGGER.info("------Data MenuItem Service Start-----");
	
		menuItemDao.save(menuItem);
		LOGGER.info("------Data Service MenuList save End-----");
	}
	
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("------Data MenuItem Service Start-----");
		return menuItemDao.getMenuItemListAdmin();
		
		//Spring JPA method
		//return menuItemDao.findAll();	
		//LOGGER.info("------Data Service MenuList save End-----");
	}	
	
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("------Data MenuItem Service Start Customer-----");
		return menuItemDao.getMenuItemListCustomer();
		//LOGGER.info("------Data Service MenuList save End-----");
	}		
	
	
	@Transactional
	public void editMenuItem(MenuItem menuItem) {
		LOGGER.info("------Data MenuItem Service Start Customer-----");
		
		MenuItem m1 = menuItemDao.getOne(menuItem.getId());
		
		m1.setActive(menuItem.isActive());
		m1.setCategory(menuItem.getCategory());
		m1.setDateOfLaunch(menuItem.getDateOfLaunch());
		m1.setFreeDelivery(menuItem.isFreeDelivery());
		m1.setName(menuItem.getName());
		m1.setPrice(menuItem.getPrice());
		
		menuItemDao.save(m1);
		//LOGGER.info("------Menu Data Edited-----");
	}	

	@Transactional
	public void addMenuItem(MenuItem menuItem) {
		LOGGER.info("------Data MenuItem Service Start Customer-----");
		menuItemDao.save(menuItem);
		
		//LOGGER.info("------Menu Data Edited-----");
	}	

	
	
	
	@Transactional
	public MenuItem getMenuItem(long menuItemId) {
		LOGGER.info("------getMenu Item-----");
		// return  menuItemDao.getOne(menuItemId);
	Optional<MenuItem>	optiona =menuItemDao.findById(menuItemId);
	      if(!optiona.isPresent()) {
	    	  throw new MenuItemNotFound("Menu item with id "+ menuItemId+" is not present");
	    	  //return new MenuItem();
	      }
	    	  return optiona.get();
	}

	
	@Transactional
	public MenuItem deleteMenuItem(long menuItemId) {
		LOGGER.info("------getMenu Item-----");
		// return  menuItemDao.getOne(menuItemId);
	Optional<MenuItem>	optiona =menuItemDao.findById(menuItemId);
	        
	      if(!optiona.isPresent()) {
	    	  throw new MenuItemNotFound("Menu item with id "+ menuItemId+" is not present");
	    	  //return new MenuItem();
	      }
	      else {
	    	  menuItemDao.deleteById(menuItemId);
	    	  return optiona.get();}
	}	
	
	
	
	
}
