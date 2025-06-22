package com.arcadia.ecommerce;

import java.math.BigDecimal;

//TODO: Volver abstracta cuando se trabaje con Herencias y cree subclases de producto
public class Product {
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private Stock stock;
	private ProductCategory category;
	private String imageURL;
	
    public Product(String id, String name, String description, BigDecimal price, boolean active, ProductCategory category, Stock stock, String imageURL) {
		 this.id = id;
		 this.name = name;
		 this.description = description;
		 this.price = price;
		 this.active = active;
		 this.category = category;
		 this.stock = stock;
		 this.imageURL = imageURL;
		}

	public String getId(){ 
		return id;
	}
	
	public String getName(){ 
		return name;
	}
	
	public String getDescription(){ 
		return description;
	}
	
	public BigDecimal getPrice(){ 
		return price;
	}
	
	public boolean isActive(){ 
		return active;
	}
	
	public ProductCategory getCategory() {
		return category;
	}
	
	public Stock getStock(){ 
		return stock;
	}
	
	public String getImageURL(){
		return imageURL;
	}
	
	public void setName(String name){ 
		this.name = name;
	}
	
	public void setDescription(String description){ 
		this.description = description;
	}
	
	public void setPrice(BigDecimal price){ 
		this.price = price;
	}
	
	public void setActive(){
		this.active = true;
	}
	
	public void setInactive(){ 
		this.active = false;
	}
	
	public void setCategory(ProductCategory category){ 
		this.category = category;
	}
	
	public void setImageURL(String imageURL){ 
		this.imageURL = imageURL;
	}	
}
