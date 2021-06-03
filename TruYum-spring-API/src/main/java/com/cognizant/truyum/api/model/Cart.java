package com.cognizant.truyum.api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long userId;
	
	private double total;
	
	//user->cart->      menulist	
	//private long menuItemId;

	
//	private List<MenuItem> menulists;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<MenuItem> menulists=new ArrayList<MenuItem>() ;
     public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

     
    public void countTotalPrice() {
    	
    	double sum=0;
    	for(MenuItem item:menulists) {
    		sum+=item.getPrice();
    	}
    	this.total=sum;
    	
    } 
     
     
    
	
}
