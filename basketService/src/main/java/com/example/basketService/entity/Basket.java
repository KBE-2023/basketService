package com.example.basketService.entity;


import java.util.List;

/**
 * Represents a customer's basket.
 */
public class Basket {

    private Long id; // unique identifier for the basket
    private Long customerId; // unique identifier for the customer who owns the basket
    private List<ProductItem> products; // list of product items added to the basket

    public Basket(Long id, Long customerId, List<ProductItem> products) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
    }

    public Basket() {

    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<ProductItem> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItem> products) {
        this.products = products;
    }

    // Add a product to the basket
    public void addProduct(ProductItem product) {
        products.add(product);
    }

    // Remove a product from the basket
    public void removeProduct(ProductItem product) {
        products.remove(product);
    }

    // Update a product in the basket
    public void updateProduct(ProductItem product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == product.getProductId()) {
                products.set(i, product);
            }
        }
    }

    // Calculate the total price of all products in the basket
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ProductItem product : products) {
            totalPrice += product.getTotalPrice();
        }
        return totalPrice;
    }

    // Return a string representation of the basket object
    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", products=" + products +
                '}';
    }
}
