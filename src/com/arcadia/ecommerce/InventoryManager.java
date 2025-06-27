package com.arcadia.ecommerce;

import java.util.List;

public interface InventoryManager {
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);
    List<Product> listAllProducts();
    void updateStock(String productId, int quantity);
}
