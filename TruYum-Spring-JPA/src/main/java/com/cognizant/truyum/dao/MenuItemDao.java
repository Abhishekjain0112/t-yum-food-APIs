package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao extends JpaRepository<MenuItem, Long> {
	
	//@Query("Select m From MenuItem m")
	@Query("From MenuItem")
	public List<MenuItem> getMenuItemListAdmin();
    
	//String sql="select * from menuitems where active=1 and dateOfLaunch<=CURDATE()";
	
	@Query("From MenuItem m where m.active=1 and m.dateOfLaunch<=CURDATE()")
	public List<MenuItem> getMenuItemListCustomer();
	
	
	//void modifyMenuItem(MenuItem menuItem);
	//MenuItem getMenuItem(long menuItemId);
  
	

}
