package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private User user;
    private OrderStatus status;
    private LocalDateTime date;
    private BigDecimal total;
    private List<OrderItem> items;
    private Payment payment;

    public Order(String id, User user, List<OrderItem> items) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario es obligatorio para crear una orden");
        }

        this.id = id;
        this.user = user;
        this.date = LocalDateTime.now();
        this.status = OrderStatus.ORDERED;
        this.items = items != null ? items : new ArrayList<>();
        this.total = calculateTotal();
    }

    private BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setStatus(OrderStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("El estatus de la orden no puede ser nulo");
        }
        this.status = newStatus;
    }

}
