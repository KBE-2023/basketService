package com.example.basketService.service;

import com.example.basketService.entity.Basket;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository {

    // Create a new basket
    Basket create(Basket basket);

    // Find a basket by ID
    Basket findById(Long id);

    // Update an existing basket
    void update(Basket basket);

    // Delete a basket by ID
    void deleteById(Long id);

}
