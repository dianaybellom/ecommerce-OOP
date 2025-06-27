package com.arcadia.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;

public class CardPayment implements PaymentProcessor {
    private PaymentStatus lastStatus;
    private String transactionId;

	@Override
	public PaymentStatus simulatePayment(BigDecimal amount) {
        System.out.println("Monto a cargar: $" + amount);
        this.transactionId = UUID.randomUUID().toString();
        this.lastStatus = PaymentStatus.PAID;
        return lastStatus;
	}

	@Override
	public boolean isSuccessful() {
		return lastStatus == PaymentStatus.PAID;
	}

	@Override
	public String getTransactionId() {
		return transactionId;
	}

}
