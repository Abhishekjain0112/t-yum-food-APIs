package com.cognizant.truyum.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.api.model.Cart;
import com.cognizant.truyum.api.model.MenuItem;
import com.cognizant.truyum.api.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/getjson")
     public Cart getJson(){
	    //return null;
		   return new Cart();
	   }
	
	@GetMapping("/addToCart/cartId/{cartid}/itemId/{itemId}")
	public Cart addToCart(@PathVariable long cartid,@PathVariable long itemId ){
		Cart cart= cartService.addToCart(cartid, itemId);
		  return cart;
	}

	@DeleteMapping("/remove/cartId/{cartid}/itemId/{itemId}")
	public Cart removeCartItem(@PathVariable long cartid,@PathVariable long itemId ){
		Cart cart= cartService.removeCartItem(cartid, itemId);
		  return cart;
	}	
	
	
	
	@GetMapping(  value = "/viewCart/{cartid}")
	public List<MenuItem> getAllMenuItemofUser(@PathVariable long cartid) {		
		return cartService.getMenuItemFromCart(cartid);		
	}
	
	
}
