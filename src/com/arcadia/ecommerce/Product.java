package com.arcadia.ecommerce;

import java.math.BigDecimal;

public abstract class Product {
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private Stock stock;
	private ProductCategory category;
	private String imageURL;
	
    public Product(String id, String name, String description, BigDecimal price, boolean active, ProductCategory category, Stock stock, String imageURL) {
    	if (name == null || name.isBlank()) 
    		throw new IllegalArgumentException("Se requiere indicar el nombre del producto");
    	if (description == null || description.isBlank()) 
    		throw new IllegalArgumentException("Se requiere indicar la descripción del producto");
    	if (price == null || price.compareTo(BigDecimal.ZERO) < 0) 
    		throw new IllegalArgumentException("El precio debe ser igual o mayor a 0");
        if (category == null) 
        	throw new IllegalArgumentException("Se requiere indicar la categoría del producto");
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
		if (name == null || name.isBlank()) 
    		throw new IllegalArgumentException("Se requiere indicar el nombre");
		this.name = name;
	}
	
	public void setDescription(String description){
		if (description == null || description.isBlank()) 
    		throw new IllegalArgumentException("Se requiere indicar la descripción del producto");
		this.description = description;
	}
	
	public void setPrice(BigDecimal price){
		/*Validación para precio nulo o menor a cero*/
		if (price == null || price.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("El precio debe ser igual o mayor a 0");
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
	
	public void displayProductInfo() {
		System.out.println(
				"El nombre del producto es: " + this.name + 
				", pertenece a la categoria: " + this.category.getName() + 
				", y su estatus es: " + (isActive() ? "ACTIVO" : "INACTIVO")
				);
	}
}
