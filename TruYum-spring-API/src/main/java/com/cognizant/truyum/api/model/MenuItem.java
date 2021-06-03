package com.cognizant.truyum.api.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="menu_item")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "m_id")
	private long id;
	
	@NotBlank
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

	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		if (name == null && other.name != null)
				return false;
		 
		if (!name.equals(other.name))
			return false;
		return true;
	}

	
	

	
	
	
	
	
	
}
