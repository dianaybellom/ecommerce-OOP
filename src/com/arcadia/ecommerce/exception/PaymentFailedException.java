package com.arcadia.ecommerce.exception;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException(String reason) {
        super("Pago fallido: " + reason);
    }
}
