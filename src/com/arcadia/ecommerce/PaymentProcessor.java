package com.arcadia.ecommerce;

import java.math.BigDecimal;

public interface PaymentProcessor {
    PaymentStatus simulatePayment(BigDecimal amount);
    boolean isSuccessful();
    String getTransactionId();
}
