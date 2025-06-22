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
}
