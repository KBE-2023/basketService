package com.example.basketService.entity;

/**
 * This class represents a product item request that is used when adding or updating a product in the basket.
 * It contains the ID of the product and the quantity of the product that is being added or updated.
 */
public class ProductItemRequest {
    private Long productId;
    private int quantity;

    /**
     * Default constructor for the class.
     */
    public ProductItemRequest() {}

    /**
     * Gets the ID of the product.
     * @return The ID of the product.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product.
     * @param productId The ID of the product.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of the product.
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the product.
     * @param quantity The quantity of the product.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
