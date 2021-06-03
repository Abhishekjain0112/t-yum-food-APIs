package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@Controller
@ComponentScan("com.cognizant.truyum.*")
public class MenuItemController {
	@Autowired
	@Qualifier("menuItemService")
	private MenuItemService menuItemService;
	private Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@RequestMapping("/hello1")
	public String hello(){
		return "Headder";
	}
	
    @RequestMapping("/hello")
    @ResponseBody
    public String Hello()    {
    System.out.println("hello");
    return "hello";
    }
	
	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model){
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Admin Menu List: {}", menuItemList);
		model.put("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-admin-3";
	}

	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model){
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Admin Menu List: {}", menuItemList);
		model.put("menuItemList", menuItemList);
		LOGGER.info("End");
		return "menu-item-list-customer";
	}
		
	
	
	
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(ModelMap model, @RequestParam("menuItemId") int id) throws ClassNotFoundException {
		LOGGER.info("Start");
		MenuItem item = menuItemService.getMenuItem(id);
		model.put("menuItem", item);
		LOGGER.debug("Items:{}", item);
		LOGGER.info("End");
		return "edit-menu-item";
	}
	
	
	@PostMapping("/edit-menu-item")
	public String editMenuItem(@ModelAttribute MenuItem menuItem, BindingResult bindingResult) {
		LOGGER.info("Start");
		if (bindingResult.hasErrors()) {
			LOGGER.debug("{}", bindingResult.getFieldErrors());
		}
		/*if(menuItem.getFreeDelivery()==null)
				menuItem.setFreeDelivery("No");
		*/
		menuItemService.editMenuItem(menuItem);
		LOGGER.info("End");
		return "edit-menu-item-status";
	}
	
	
	@RequestMapping("/success")
	public String success(){
		return "customerAddSuccess";
	}
	
	
	
	
}
