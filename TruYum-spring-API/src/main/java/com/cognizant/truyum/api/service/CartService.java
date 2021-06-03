package com.cognizant.truyum.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.api.dao.CartDao;
import com.cognizant.truyum.api.dao.MenuItemDao;
import com.cognizant.truyum.api.exception.CartEmptyException;
import com.cognizant.truyum.api.exception.CartNotFound;
import com.cognizant.truyum.api.model.Cart;
import com.cognizant.truyum.api.model.MenuItem;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	MenuItemDao menuItemDao;
	

	@Transactional
	public Cart addToCart(long id,long menuItemId) {
		Optional<Cart> optional = cartDao.findById(id);
		Cart cart=null;
		if(optional.isPresent())
		   cart=optional.get();
		else 
			cart =new Cart();
		MenuItem item = null;
		Optional<MenuItem>	optionalMenuItem =menuItemDao.findById(menuItemId);
	      if(optionalMenuItem.isPresent()) 
		       item=optionalMenuItem.get();
		  cart.getMenulists().add(item);
		  cart.setUserId(cart.getId());
		  cart.countTotalPrice();
		  cartDao.save(cart);
		  return cart;
	}

	
	@Transactional
	public Cart removeCartItem(long id,long menuItemId) {
		
		Optional<Cart> optional = cartDao.findById(id);
		Cart cart=null;
		if(optional.isPresent()) {
		  
			cart=optional.get();
		   
		   MenuItem item = null;
			Optional<MenuItem>	optionalMenuItem =menuItemDao.findById(menuItemId);
		      if(optionalMenuItem.isPresent()) 
			       item=optionalMenuItem.get();
		      for(MenuItem i:cart.getMenulists()) {
		    	  if(item.equals(i)) {
		    		  cart.getMenulists().remove(i);
		    		  break;
		    	  }
		    	  
		      } 
		      cart.countTotalPrice();
		      cartDao.save(cart);
		      return cart;
		}
		throw new CartNotFound("Cart with id "+id +" not found.")	;
		 // return new Cart();
	
	}	
	
	
	
	
	
	
	
	@Transactional
	public List<MenuItem> getMenuItemFromCart(long cartId){
		//MenuItemService menuService= new MenuItemService();		  
		Optional<Cart> optional = cartDao.findById(cartId);
		Cart cart=new Cart();
		if(optional.isPresent()) {
		   cart=optional.get();	
		   if(cart.getMenulists().size()==0)
			   throw new CartEmptyException("Cart with id "+cartId+" is Empty!");
		   
		return cart.getMenulists();
		} 
		throw new CartNotFound("Cart with id "+cartId +" not found.");
		
	}
	

}