package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Storefront implements OrderStatusObserver {

	@Override
	public void onOrderStatusChanged(String orderId, String newStatus) {
		System.out.println("Storefront ha sido notificado: Orden " + orderId + " ha cambiado a " + newStatus);

	}
	
    public Order createOrder(User user, Cart cart, String shippingAddress) {
        if (cart == null || cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("El carrito está vacío");
        }
        if (user == null) {
            throw new IllegalArgumentException("Se requiere un usuario para crear una orden");
        }

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            BigDecimal price = product.getPrice();

            OrderItem orderItem = new OrderItem(
                UUID.randomUUID().toString(),
                product.getId(),
                quantity,
                price,
                product.getName()
            );
            orderItems.add(orderItem);
        }

        String orderId = UUID.randomUUID().toString();
        Order order = new Order(orderId, user, orderItems);
        return order;
    }

}
