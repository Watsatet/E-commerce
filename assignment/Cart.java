package org.assignment;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void addProduct(Product product) throws CloneNotSupportedException {
        Product clonedProduct = (Product) product.clone();
        items.put(clonedProduct, items.getOrDefault(clonedProduct, 0) + 1);
    }

    public void updateQuantity(Product product, int quantity) throws CloneNotSupportedException {
        if (quantity > 0) {
            Product clonedProduct = (Product) product.clone();
            items.put(clonedProduct, quantity);
        } else {
            items.remove(product);
        }
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public void displayCartItems() {
        System.out.println("Cart Items:");
        items.forEach((product, quantity) -> {
            System.out.println(quantity + " x " + product.getName());
        });
    }

    public double calculateTotal() {
        return items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum();
    }
}
