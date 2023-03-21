package com.kbe2223.basketservice.controller;

import com.kbe2223.basketservice.entity.Basket;
import com.kbe2223.basketservice.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The BasketController class defines the REST endpoints for the Basket service.
 */
@RestController
@CrossOrigin
@RequestMapping("/baskets")
public class BasketController {

    @Autowired
    private BasketService basketService;

    /**
     * Retrieves a basket record by ID.
     *
     * @param id The ID of the basket record to retrieve.
     * @return A ResponseEntity containing the retrieved Basket and an HTTP status code.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Long id) {
        Basket basket = basketService.getBasketById(id);
        if (basket != null) {
            return new ResponseEntity<>(basket, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * Returns a list of all baskets in the database.
     *
     * @return a list of all baskets in the database, or NOT_FOUND if the database is empty
     */
    @GetMapping("/")
    public ResponseEntity<List<Basket>> getAllBaskets() {
        List<Basket> baskets = basketService.getAllBaskets();
        if (!baskets.isEmpty()) {
            return new ResponseEntity<>(baskets, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * Creates a new basket record.
     *
     * @param basket The Basket object representing the new basket record.
     * @return A ResponseEntity containing the created Basket and an HTTP status code.
     */
    @PostMapping(value = "/",consumes = {"*/*"})
    public ResponseEntity<Basket> createBasket(@RequestBody Basket basket) {
        Basket createdBasket = basketService.createBasket(basket);
        return new ResponseEntity<>(createdBasket, HttpStatus.CREATED);
    }

    /**
     * Updates an existing basket record.
     *
     * @param id The ID of the basket record to update.
     * @param basket The updated Basket object representing the new basket information.
     * @return A ResponseEntity containing the updated Basket and an HTTP status code.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable Long id, @RequestBody Basket basket) {
        Basket updatedBasket = basketService.updateBasket(id, basket);
        if (updatedBasket != null) {
            return new ResponseEntity<>(updatedBasket, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Deletes an existing basket record.
     *
     * @param id The ID of the basket record to delete.
     * @return A ResponseEntity with an HTTP status code indicating success or failure.
     */
   /* @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBasket(@PathVariable Long id) {
        basketService.deleteBasket(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/

}
