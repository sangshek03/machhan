package com.ecommerce.assign.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private String brand;
	private String imageUrl;
	private int quantity;
	private int price;
	private int discountPrice;
	
	public Product() {
		
	}
	
	public Product(Long id, String title, String description, String brand, String imageUrl, int quantity, int price,
			int discountPrice) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.price = price;
		this.discountPrice = discountPrice;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product [title=" + title + ", id=" + id + ", description=" + description + ", brand=" + brand
				+ ", imageUrl=" + imageUrl + ", quantity=" + quantity + ", price=" + price + ", discountPrice="
				+ discountPrice + "]";
	}
}
