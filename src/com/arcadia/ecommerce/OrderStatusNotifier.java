package com.arcadia.ecommerce;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusNotifier {
    private static final List<OrderStatusObserver> observers = new ArrayList<>();

    public static void subscribe(OrderStatusObserver observer) {
        observers.add(observer);
    }

    public static void unsubscribe(OrderStatusObserver observer) {
        observers.remove(observer);
    }

    public static void notifyObservers(String orderId, String newStatus) {
        for (OrderStatusObserver observer : observers) {
            observer.onOrderStatusChanged(orderId, newStatus);
        }
    }
}
