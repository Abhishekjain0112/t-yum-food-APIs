package com.cognizant.truyum.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="menu_item")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "m_id")
	private long id;
	
	@Column(name="m_name")
	private String name;
	
	@Column(name="m_price")
	private double price;
	
	@Column(name="m_active")
	private boolean active;
	
	@Column(name="m_date_of_launch")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfLaunch;
	
	
	@Column(name="m_category")
	private String category;
	
	@Column(name="m_free_delivery")
	private boolean freeDelivery;

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuItem(long id, String name, double price, boolean active, LocalDate dateOfLaunch, String category,
			boolean freeDelivery) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		
		this.dateOfLaunch = dateOfLaunch;
		
		this.category = category;
		this.freeDelivery = freeDelivery;
	}

	
	
	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(LocalDate dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
				+ dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
	}

	
	

	
	
	
	
	
	
}
