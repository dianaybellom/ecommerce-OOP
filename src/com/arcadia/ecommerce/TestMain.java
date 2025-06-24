package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestMain {
	
/* ---------------------------------Productos--------------------------------------*/
	/* Creación de categoria*/
	public static void main(String[] args) {
        ProductCategory category = new ProductCategory(
                "CAT1", 
                "Blusas", 
                "Blusas de primavera", 
                true
            );
            /*System.out.println("Categoría: " + category.getName());*/
        ProductCategory category1 = new ProductCategory(
                "CAT2", 
                "Tarjetas de regalo", 
                "Tarjetas recargables", 
                true
            );
        
	/* Definir stock 1 */
        Stock stock1 = new Stock(
                "P001", 
                20, 
                LocalDateTime.now()
            );
         /*   System.out.println("Stock 1 inicial: " + stock1.getQuantity());    */

	/* Definir stock 2 */
	    Stock stock2 = new Stock(
	            "TRJ001", 
	            10, 
	            LocalDateTime.now()
	    	);
        	/*System.out.println("Stock 2 inicial: " + stock2.getQuantity());    */
                
	/* Creación de producto 1*/
        Product product1 = new PhysicalProduct(
                "P001", 
                "Blusa", 
                "Blusa fresca para el verano", 
                new BigDecimal("200.99"), 
                false, 
                category, 
                stock1, 
                "http://img.jpg",
                "XL",
                "Rosa",
                Arrays.asList("Algodón", "Lino"),
                "Cerisier",
                true
            );
            
            product1.displayProductInfo();
            
          /*  System.out.println(product1.getStock().isAvailable(1));*/
 
    	/* Creación de producto 2*/
        Product product2 = new VirtualProduct(
                "TRJ001", 
                "Tarjeta de regalo", 
                "Tarjeta de regalo recargable", 
                new BigDecimal("2500.00"), 
                true, 
                category1, 
                stock2, 
                "",
                "xy54z9",
                LocalDate.of(2025, 12, 31),
                new BigDecimal("2500.00")
            );
            
            
        product2.displayProductInfo();
            
        /*System.out.println(product2.getStock().isAvailable(1));*/

        /* ---------------------------------Carrito--------------------------------*/
        /* Creación de carrito */
        Cart cart = new Cart("cdf8d8d0-e046-4390-91da-1272c4d686a0", "1d58aba9-2f2a-4232-9330-c19c12c90b85");
        
        /*Productos*/
        CartItem item1 = new CartItem(cart.getId(), product1, 2);
        /*CartItem item2 = new CartItem(cart.getId(), product2, 2);*/
        
        /* Agregar al carrito */
        boolean added = cart.addItem(item1);
        System.out.println("¿Se añadió item1? " + added);
        
        boolean added1 = cart.addItem(product2, 1);
        System.out.println("¿Se añadió item2? " + added);

        /* Mostrar total */
        System.out.println("Total del carrito: $" + cart.getTotal());
        
        /*Remover del carrito*/
        boolean removed = cart.removeItem(item1.getProduct().getId());
        System.out.println("¿Se eliminó item1? " + removed);
        
        /* Mostrar nuevo total */
        System.out.println("Total del carrito: $" + cart.getTotal());        
	}

}
