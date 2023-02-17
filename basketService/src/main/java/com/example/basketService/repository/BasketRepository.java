package com.example.basketService.repository;

import com.example.basketService.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {

    /**
     * Finds a basket by customer ID.
     *
     * @param customerId the customer ID to search for
     * @return an Optional containing the matching Basket, or an empty Optional if not found
     */
    Optional<Basket> findByCustomerId(Long customerId);
}
