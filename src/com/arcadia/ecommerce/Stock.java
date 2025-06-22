package com.arcadia.ecommerce;

import java.time.LocalDateTime;

public class Stock {
	private String productId;
	private int quantity;
	private LocalDateTime updatedAt;
	
	public Stock(String productId, int quantity, LocalDateTime updatedAt) {
		this.productId = productId;
		this.quantity = quantity;
		this.updatedAt = updatedAt;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.updatedAt = LocalDateTime.now();
	}
	
	public boolean isAvailable(int requiredQuantity) {
		return this.quantity >= requiredQuantity;
	}
	
	public void increaseStock(int quantity) {
        this.quantity += quantity;
        this.updatedAt = LocalDateTime.now();		
	}
	
	public void reduceStock(int quantity) {
        this.quantity -= quantity;
        this.updatedAt = LocalDateTime.now();			
	}
}
