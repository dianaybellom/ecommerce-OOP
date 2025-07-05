package com.arcadia.ecommerce;

public interface OrderStatusObserver {
	  void onOrderStatusChanged(String orderId, String newStatus);
}
