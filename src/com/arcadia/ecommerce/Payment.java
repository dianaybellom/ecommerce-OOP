package com.arcadia.ecommerce;

import java.time.LocalDateTime;

public class Payment {
    private final String id;
    private final String orderId; //TODO: Relacionar con clase Order cuando la implemente
    private final PaymentStatus status;
    private final LocalDateTime capturedAt;

    public Payment(String id, String orderId, PaymentStatus status, LocalDateTime capturedAt) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.capturedAt = capturedAt;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCapturedAt() {
        return capturedAt;
    }

    public boolean isSuccessful() {
        return status == PaymentStatus.PAID;
    }
}
