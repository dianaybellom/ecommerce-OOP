package com.arcadia.ecommerce.exception;

public class InsufficientStockException extends RuntimeException {
	public InsufficientStockException(String productId, int requested, int available) {
        super("No hay suficiente stock del producto " + productId + ". Solicitado: " + requested + ", Disponible: " + available);
	}
}
