package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.arcadia.ecommerce.exception.InsufficientStockException;

public class Cart {
    private String id;
    private String userId;
    private List<CartItem> items;

    public Cart(String id, String userId) {
        this.id     = id;
        this.userId = userId;
        this.items  = new ArrayList<>();
    }

    public String getId() {
    	return id;
    }
    
    public boolean addItem(CartItem item) {
        return items.add(item);
    }

    public boolean addItem(Product product, int quantity) {
    	if (product == null) 
    		throw new IllegalArgumentException("Producto no puede ser nulo");
        if (quantity <= 0) 
        	throw new IllegalArgumentException("Quantity debe ser > 0");
        if (!product.getStock().isAvailable(quantity)) {
            throw new InsufficientStockException(product.getId(), quantity, product.getStock().getQuantity());
        }
        CartItem item = new CartItem(this.id, product, quantity);
        return addItem(item);
    }
    
    public boolean removeItem(String productId) {
    	Iterator<CartItem> it = items.iterator();
    	while (it.hasNext()) {
    		CartItem item = it.next();
    		if (item.getProduct().getId().equals(productId)) {
    			it.remove();
    			return true;
    		}
    	}
        return false;
    }


    public boolean updateItemQuantity(String productId, int quantity) {
        // TODO: A implementar
        return false;
    }


    public BigDecimal getTotal() {
        return items.stream().map(CartItem::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

  
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public List<CartItem> getItems() {
        return items;
    }

}