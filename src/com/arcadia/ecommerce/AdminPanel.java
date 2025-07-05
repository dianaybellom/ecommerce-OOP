package com.arcadia.ecommerce;

import java.util.List;

public class AdminPanel implements InventoryManager {
    private List<Product> products;
    private List<Order> orders;

    public AdminPanel(List<Product> products, List<Order> orders) {
        this.products = products;
        this.orders = orders != null ? orders : List.of();
    }
    
	@Override
	public void createProduct(Product product) {
		if (product instanceof PhysicalProduct) {
			createPhysicalProduct((PhysicalProduct) product);
		} else if (product instanceof VirtualProduct) {
            createVirtualProduct((VirtualProduct) product);
        } else {
            throw new IllegalArgumentException("Tipo de producto no soportado");
        }

	}

    private void createPhysicalProduct(PhysicalProduct product) {
        products.add(product);
    }

    private void createVirtualProduct(VirtualProduct product) {
        products.add(product);
    }
    
	@Override
	public void updateProduct(Product product) {
        deleteProduct(product.getId());
        createProduct(product);
	}

	@Override
	public void deleteProduct(String productId) {
		for (Product p : products) {
		    if (p.getId().equals(productId)) {
		        products.remove(p);
		        break;
		    }
		}
	}

	@Override
	public List<Product> listAllProducts() {
		return List.copyOf(products);
	}

	@Override
	public void updateStock(String productId, int quantity) {
        for (Product p : products) {
            if (p.getId().equals(productId)) {
            	p.getStock().setQuantity(quantity);
                break;
            }
        }

	}
	
    public Order getOrder(String orderId) {
        for (Order order : orders) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
	
    public void updateOrderStatus(String orderId, String newStatusStr) {
        Order order = getOrder(orderId);
        if (order != null) {
            OrderStatus newStatus = OrderStatus.valueOf(newStatusStr);
            order.setStatus(newStatus);
            OrderStatusNotifier.notifyObservers(orderId, newStatus.name());
        }
    }


}
