package com.kbe2223.basketservice.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Basket {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double totalPrice;


    private String products;

    @Id
    private Long customerId;

    public Basket() {}

    public Basket(double totalPrice, String products, Long customerId) {
        this.totalPrice = totalPrice;
        this.products = products;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
