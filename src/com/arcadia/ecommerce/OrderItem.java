package com.arcadia.ecommerce;

import java.math.BigDecimal;

public class OrderItem {
    private String orderId;
    private String productId;
    private int quantity;
    private BigDecimal unitPrice;
    private String productName;

    public OrderItem(String orderId, String productId, int quantity, BigDecimal unitPrice, String productName) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getTotalPrice() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
