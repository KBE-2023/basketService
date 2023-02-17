package com.example.basketService.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Basket entity represents a shopping basket in the Basket microservice.
 */
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketItem> items;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "currency")
    private String currency;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    /**
     * Gets the ID of the basket.
     *
     * @return The ID of the basket.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the basket.
     *
     * @param id The ID of the basket.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ID of the customer who owns the basket.
     *
     * @return The ID of the customer who owns the basket.
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the ID of the customer who owns the basket.
     *
     * @param customerId The ID of the customer who owns the basket.
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the list of items in the basket.
     *
     * @return The list of items in the basket.
     */
    public List<BasketItem> getItems() {
        return items;
    }

    /**
     * Sets the list of items in the basket.
     *
     * @param items The list of items in the basket.
     */
    public void setItems(List<BasketItem> items) {
        this.items = items;
    }

    /**
     * Gets the total price of the items in the basket.
     *
     * @return The total price of the items in the basket.
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the items in the basket.
     *
     * @param totalPrice The total price of the items in the basket.
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the currency code (ISO 4217) of the basket.
     *
     * @return The currency code (ISO 4217) of the basket.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code (ISO 4217) of the basket.
     *
     * @param currency The currency code (ISO 4217) of the basket.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the date and time when the basket was created.
     *
     * @return The date and time when the basket was created.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the date and time when the basket was created.
     *
     * @param createdAt The date and time when the basket was created.
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the date and time when the basket was last updated.
     *
     * @return The date and time when the basket was last updated.
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the date and time when the basket was last updated.
     *
     * @param updatedAt The date and time when the basket was last updated.
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
