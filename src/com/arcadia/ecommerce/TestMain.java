package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestMain {
	/* Creación de categoria*/
	public static void main(String[] args) {
        ProductCategory category = new ProductCategory(
                "CAT1", 
                "Blusas", 
                "Blusas de primavera", 
                true
            );
            System.out.println("Categoría: " + category.getName());
 
	/* Definir stock 1 */
        Stock stock1 = new Stock(
                "P001", 
                20, 
                LocalDateTime.now()
            );
            System.out.println("Stock 1 inicial: " + stock1.getQuantity());           

	/* Definir stock 2 */
	    Stock stock2 = new Stock(
	            "P002", 
	            10, 
	            LocalDateTime.now()
	    	);
        	System.out.println("Stock 2 inicial: " + stock2.getQuantity());     
                
	/* Creación de producto 1*/
        Product product1 = new Product(
                "P001", 
                "Blusa", 
                "100% algodón", 
                new BigDecimal("200.99"), 
                true, 
                category, 
                stock1, 
                "http://img.jpg"
            );
            System.out.println("Producto 1: " + product1.getName() 
            + "	Precio: " + product1.getPrice());
            
        System.out.println(product1.getStock().isAvailable(1));
 
    	/* Creación de producto 2*/
        Product product2 = new Product(
                "P002", 
                "Blusa 2", 
                "100% polyester", 
                new BigDecimal("300.99"), 
                true, 
                category, 
                stock2, 
                "http://img.jpg"
            );
            System.out.println("Producto 2: " + product2.getName() 
            + "	Precio: " + product2.getPrice());
            
        System.out.println(product2.getStock().isAvailable(1));

        /* Creación de carrito */
        Cart cart = new Cart("cdf8d8d0-e046-4390-91da-1272c4d686a0", "1d58aba9-2f2a-4232-9330-c19c12c90b85");
        
        /*Productos*/
        CartItem item1 = new CartItem(cart.getId(), product1, 2);
        
        /* Agregar al carrito */
        boolean added = cart.addItem(item1);
        System.out.println("¿Se añadió item1? " + added);

        /* Mostrar total */
        System.out.println("Total del carrito: $" + cart.getTotal());
        
        /*Remover del carrito*/
        boolean removed = cart.removeItem(item1.getProduct().getId());
        System.out.println("¿Se eliminó item1? " + removed);
	}

}
