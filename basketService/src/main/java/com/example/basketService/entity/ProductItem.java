package com.example.basketService.entity;

public class ProductItem {

    private Long productId; // unique identifier for the product
    private int quantity; // quantity of the product in the basket
    private double totalPrice; // total price of the product in the basket

    public ProductItem(Long productId, int quantity, double totalPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // Getter and Setter methods
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Return a string representation of the product item object
    @Override
    public String toString() {
        return "ProductItem{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
