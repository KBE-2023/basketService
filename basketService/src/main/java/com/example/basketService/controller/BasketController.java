package com.example.basketService.controller;

import com.example.basketService.entity.Basket;
import com.example.basketService.entity.BasketItem;
import com.example.basketService.exception.BasketItemNotFoundException;
import com.example.basketService.exception.BasketNotFoundException;
import com.example.basketService.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    private BasketService basketService;

    /**
     * Create a new basket for a given customer ID.
     *
     * @param customerId the ID of the customer for whom the basket is being created
     * @return the newly created Basket object
     */
    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestParam("customerId") Long customerId) {
        Basket basket = basketService.createBasket(customerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(basket);
    }

    /**
     * Retrieve an existing basket for a given customer ID.
     *
     * @param customerId the ID of the customer whose basket is being retrieved
     * @return the Basket object for the given customer ID
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<Basket> getBasket(@PathVariable("customerId") Long customerId) throws BasketNotFoundException {
        Basket basket = basketService.getBasket(customerId);
        return ResponseEntity.ok(basket);
    }

    /**
     * Add a new item to an existing basket.
     *
     * @param customerId  the ID of the customer whose basket is being updated
     * @param itemRequest the BasketItemRequest object containing the details of the item to be added
     * @return the updated Basket object
     */
    @PostMapping("/{customerId}/items")
    public ResponseEntity<Basket> addItemToBasket(@PathVariable("customerId") Long customerId,
                                                  @RequestBody BasketItem itemRequest) throws BasketNotFoundException {
        Basket basket = basketService.addItemToBasket(customerId, itemRequest.getProductId(),
                itemRequest.getQuantity(), itemRequest.getPrice(), itemRequest.getCurrency());
        return ResponseEntity.ok(basket);
    }

    /**
     * Remove an item from an existing basket.
     *
     * @param customerId the ID of the customer whose basket is being updated
     * @param productId  the ID of the product to be removed from the basket
     * @return the updated Basket object
     */
    @DeleteMapping("/{customerId}/items/{productId}")
    public ResponseEntity<Basket> removeItemFromBasket(@PathVariable("customerId") Long customerId,
                                                       @PathVariable("productId") Long productId) throws BasketItemNotFoundException, BasketNotFoundException {
        Basket basket = basketService.removeItemFromBasket(customerId, productId);
        return ResponseEntity.ok(basket);
    }
}
