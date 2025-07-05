package com.arcadia.ecommerce;

public class StorefrontObserver implements OrderStatusObserver {

	@Override
	public void onOrderStatusChanged(String orderId, String newStatus) {
		System.out.println("Storefront ha sido notificado: Orden " + orderId + " ha cambiado a " + newStatus);
	}

}
