package com.cognizant.truyum.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.api.model.Cart;
import com.cognizant.truyum.api.model.MenuItem;

public interface CartDao extends JpaRepository<Cart, Long>
{
      /* 
	@Query("select c.menuItemId from Cart c where c.userId=:userId")
	public List<Long> getAllMenuItemsId(long userId);
	*/
}
