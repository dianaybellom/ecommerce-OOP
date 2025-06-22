package com.arcadia.ecommerce;

public class ProductCategory {
    private String id;
    private String name;
    private String description;
    private boolean active;

    public ProductCategory(String id, String name, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public String getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
    public String getDescription() { 
    	return description;
    }
    
    public boolean isActive() { 
    	return active;
    }

    public void setActive() { 
    	this.active = true;
    }
    
    public void setInactive() { 
    	this.active = false;
    }
}
