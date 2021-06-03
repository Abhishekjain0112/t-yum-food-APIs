package com.cognizant.truyum;



import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;



@SpringBootApplication
@ComponentScan("com.cognizant.truyum.*")
public class TruYumSpringJpaApplication {

	@Autowired
	public MenuItemService menuItemService;
	
	public static Logger LOGGER = LoggerFactory.getLogger(TruYumSpringJpaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TruYumSpringJpaApplication.class, args);
	
		/*	ApplicationContext context=SpringApplication.run(TruYumSpringJpaApplication.class, args);
		 menuItemService= context.getBean(MenuItemService.class);
		
				saveMenuItems();
				shoeMenuItemsAdmin();
				shoeMenuItemsCustomer();
				editMenuItems();
			  getMenuItemById(4);	*/
	}
	
	//---------------------------------------------------
	
	
	/*
	private static void saveMenuItems(){
		LOGGER.info("------Data Save Start-----");
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
		LOGGER.info("------Data Saved-----");
	}
	
	
	
	private static void shoeMenuItemsAdmin(){
		
		LOGGER.info("------Show Menu Items Admin Start-----");
		List<MenuItem> menuItems=menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Menu Items{} :", menuItems);
		menuItems.forEach(System.out::println);
		
		LOGGER.info("------Show Menu Items Admin End-----");
		
	}
	
	private static void shoeMenuItemsCustomer(){	
		LOGGER.info("------Show Menu Items Customer Start-----");
		List<MenuItem> menuItems=menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Menu Items{} :", menuItems);
		menuItems.forEach(System.out::println);		
		LOGGER.info("------Show Menu Items Customer End-----");	
	}	
	
	private static void editMenuItems(){	
		LOGGER.info("------Edit Menu Items Customer Start-----");
		MenuItem menuItem=new MenuItem(1, "Sandwich1", 199, true,LocalDate.of(2017, 03, 15) ,"Main Course", true);
		menuItemService.editMenuItem(menuItem);
		LOGGER.debug("Menu Items{} :", menuItem);	
		LOGGER.info("------Edit Menu Items Customer End-----");	
	}		
	

	private static void getMenuItemById(long id){
		LOGGER.info("------get Menu Items by id Start-----");	
		MenuItem menuItem = menuItemService.getMenuItem(2);
		LOGGER.debug("MenuItem{}:",menuItem);
		//LOGGER.debug("MenuItem{}:",menuItem.getId() +"   "+ menuItem.getName());
		LOGGER.info("------get Menu Items by id Ends-----");	
		
	}*/
	
	

}
