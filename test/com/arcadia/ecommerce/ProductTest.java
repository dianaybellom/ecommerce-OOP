package com.arcadia.ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    public void shouldCreatePhysicalProductSuccessfully() {
        ProductCategory category = new ProductCategory("C1", "Clothing", "Shirts", true);
        Stock stock = new Stock("P001", 10, LocalDateTime.now());
        Product p = new PhysicalProduct("P001", "Shirt", "Blue shirt", new BigDecimal("45.00"), true, category, stock, "", "L", "Blue", List.of("Cotton"), "Summer", true);
        assertEquals("Shirt", p.getName());
    }

    @Test
    public void shouldThrowExceptionWhenPriceNegative() {
        ProductCategory category = new ProductCategory("C1", "Clothing", "Shirts", true);
        Stock stock = new Stock("P002", 5, LocalDateTime.now());
        assertThrows(IllegalArgumentException.class, () -> {
            new PhysicalProduct("P002", "Shirt", "Bad price", new BigDecimal("-10"), true, category, stock, "", "M", "Black", List.of("Cotton"), "Winter", true);
        });
    }

}
