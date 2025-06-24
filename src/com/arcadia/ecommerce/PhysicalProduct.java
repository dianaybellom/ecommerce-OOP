package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.util.List;

public class PhysicalProduct extends Product {
    private String size;
    private String color;
    private List<String> materials;
    private String collection;
    private boolean returnable;

    public PhysicalProduct(
        String id,
        String name,
        String description,
        BigDecimal price,
        boolean active,
        ProductCategory category,
        Stock stock,
        String imageURL,
        String size,
        String color,
        List<String> materials,
        String collection,
        boolean returnable
    ) {
        super(id, name, description, price, active, category, stock, imageURL);
        this.size = size;
        this.color = color;
        this.materials = materials;
        this.collection = collection;
        this.returnable = returnable;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public String getCollection() {
        return collection;
    }

    public boolean isReturnable() {
        return returnable;
    }

    public void setReturnable(boolean returnable) {
        this.returnable = returnable;
    }
    
    @Override
    public void displayProductInfo() {
    	super.displayProductInfo();
    	System.out.println(
				"Asi mismo, es un producto FISICO, " +
				"de color: " + this.color + 
				", y hecho con los materiales: " + this.materials
				);
    }
}
