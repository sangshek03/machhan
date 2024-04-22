package com.ecommerce.assign.demo.request;

public class ProductRequest {
	
	private Long id;
	private String title;
	private String description;
	private String brand;
	private String imageUrl;
	private int quantity;
	private int price;
	private int discountPrice;
	
	public ProductRequest() {
		
	}
	
	public ProductRequest(Long id, String title, String description, String brand, String imageUrl, int quantity,
			int price, int discountPrice) {
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
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	
	
}
