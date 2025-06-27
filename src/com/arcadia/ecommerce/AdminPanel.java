package com.arcadia.ecommerce;

import java.util.List;

public class AdminPanel implements InventoryManager {
    private List<Product> products;
    //private List<Order> orders; TODO: Insertar ordenes

    public AdminPanel(List<Product> products) {
        this.products = products;
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

}
