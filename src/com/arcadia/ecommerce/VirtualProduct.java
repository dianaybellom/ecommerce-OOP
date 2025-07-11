package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VirtualProduct extends Product {
    private String code;
    private LocalDate expirationDate;
    private BigDecimal redeemableAmount;

    public VirtualProduct(
        String id,
        String name,
        String description,
        BigDecimal price,
        boolean active,
        ProductCategory category,
        Stock stock,
        String imageURL,
        String code,
        LocalDate expirationDate,
        BigDecimal redeemableAmount
    ) {
        super(id, name, description, price, active, category, stock, imageURL);
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Código es requerido");
        }
        if (expirationDate == null || expirationDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de expiración es inválida");
        }
        if (redeemableAmount == null || redeemableAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto canjeable debe ser mayor a 0");
        }        
        this.code = code;
        this.expirationDate = expirationDate;
        this.redeemableAmount = redeemableAmount;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public BigDecimal getRedeemableAmount() {
        return redeemableAmount;
    }

    public boolean isRedeemable() {
        return redeemableAmount.compareTo(BigDecimal.ZERO) > 0 && !isExpired();
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
    
    @Override
    public void displayProductInfo() {
    	super.displayProductInfo();
    	System.out.println(
				"Asi mismo, es un producto VIRTUAL, " +
				"el código único es: " + this.code + 
				", y expira el: " + this.expirationDate
				);
    }    
}
