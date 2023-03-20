package com.kbe2223.basketservice.service;

import com.kbe2223.basketservice.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
