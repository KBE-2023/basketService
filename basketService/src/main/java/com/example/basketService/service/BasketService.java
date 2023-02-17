package com.example.basketService.service;

import com.example.basketService.entity.Basket;
import com.example.basketService.entity.BasketItem;
import com.example.basketService.exception.BasketItemNotFoundException;
import com.example.basketService.exception.BasketNotFoundException;
import com.example.basketService.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public Basket createBasket(Long customerId) {
        Basket basket = new Basket();
        basket.setCustomerId(customerId);
        basket.setCreatedAt(LocalDateTime.now());
        basket.setUpdatedAt(LocalDateTime.now());
        return basketRepository.save(basket);
    }

    public Basket getBasket(Long customerId) throws BasketNotFoundException {
        Optional<Basket> optionalBasket = basketRepository.findByCustomerId(customerId);
        if (optionalBasket.isPresent()) {
            return optionalBasket.get();
        } else {
            throw new BasketNotFoundException("Basket not found for customer ID: " + customerId);
        }
    }

    public Basket addItemToBasket(Long customerId, Long productId, Integer quantity, BigDecimal price, String currency) throws BasketNotFoundException {
        Basket basket = getBasket(customerId);
        List<BasketItem> items = basket.getItems();
        Optional<BasketItem> optionalItem = items.stream().filter(item -> item.getProductId().equals(productId)).findFirst();
        if (optionalItem.isPresent()) {
            BasketItem item = optionalItem.get();
            item.setQuantity(item.getQuantity() + quantity);
            item.setPrice(price);
            item.setCurrency(currency);
        } else {
            BasketItem item = new BasketItem();
            item.setBasket(basket);
            item.setProductId(productId);
            item.setQuantity(quantity);
            item.setPrice(price);
            item.setCurrency(currency);
            items.add(item);
        }
        basket.setItems(items);
        basket.setTotalPrice(calculateTotalPrice(items));
        basket.setCurrency(currency);
        basket.setUpdatedAt(LocalDateTime.now());
        return basketRepository.save(basket);
    }

    public Basket removeItemFromBasket(Long customerId, Long productId) throws BasketNotFoundException, BasketItemNotFoundException {
        Basket basket = getBasket(customerId);
        List<BasketItem> items = basket.getItems();
        Optional<BasketItem> optionalItem = items.stream().filter(item -> item.getProductId().equals(productId)).findFirst();
        if (optionalItem.isPresent()) {
            BasketItem item = optionalItem.get();
            items.remove(item);
            basket.setItems(items);
            basket.setTotalPrice(calculateTotalPrice(items));
            basket.setUpdatedAt(LocalDateTime.now());
            return basketRepository.save(basket);
        } else {
            throw new BasketItemNotFoundException("Item not found in basket: " + productId);
        }
    }

    private BigDecimal calculateTotalPrice(List<BasketItem> items) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (BasketItem item : items) {
            totalPrice = totalPrice.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return totalPrice;
    }
}

