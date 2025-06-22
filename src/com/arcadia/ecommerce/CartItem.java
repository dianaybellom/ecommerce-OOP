package com.arcadia.ecommerce;

import java.math.BigDecimal;

public class CartItem {
    private String cartId;
    private Product product;
    private int quantity;

    public CartItem(String cartId, Product product, int quantity) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
    }

    
    public Product getProduct() {
    	return product;
    }
    
    public int getQuantity() {
    	return quantity;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public BigDecimal getSubtotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}