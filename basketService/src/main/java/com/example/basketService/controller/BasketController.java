package com.example.basketService.controller;

import com.example.basketService.entity.Basket;
import com.example.basketService.entity.ProductItemRequest;
import com.example.basketService.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    // Constructor for the BasketController class, which injects an instance of BasketService
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    // REST endpoint for creating a new basket
    @PostMapping
    public ResponseEntity<Basket> createBasket() {
        Basket basket = basketService.createBasket();
        return new ResponseEntity<>(basket, HttpStatus.CREATED);
    }

    // REST endpoint for retrieving a basket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasket(@PathVariable Long id) {
        Basket basket = basketService.getBasket(id);
        if (basket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(basket, HttpStatus.OK);
    }

    // REST endpoint for adding a product to a basket
    @PostMapping("/{basketId}/products")
    public ResponseEntity<Void> addProductToBasket(@PathVariable Long basketId, @RequestBody ProductItemRequest productItemRequest) {
        basketService.addProductToBasket(basketId, productItemRequest.getProductId(), productItemRequest.getQuantity());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // REST endpoint for removing a product from a basket
    @DeleteMapping("/{basketId}/products/{productId}")
    public ResponseEntity<Void> removeProductFromBasket(@PathVariable Long basketId, @PathVariable Long productId) {
        basketService.removeProductFromBasket(basketId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // REST endpoint for updating a product in a basket
    @PutMapping("/{basketId}/products/{productId}")
    public ResponseEntity<Void> updateProductInBasket(@PathVariable Long basketId, @PathVariable Long productId, @RequestBody ProductItemRequest productItemRequest) {
        basketService.updateProductInBasket(basketId, productId, productItemRequest.getQuantity());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // REST endpoint for getting the total price of a basket
    @GetMapping("/{id}/total-price")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long id) {
        double totalPrice = basketService.getTotalPrice(id);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }

}
