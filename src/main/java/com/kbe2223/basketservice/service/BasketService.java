package com.kbe2223.basketservice.service;

import com.kbe2223.basketservice.entity.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The BasketService class provides the business logic for interacting with the BasketRepository.
 */
@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    /**
     * Retrieves a basket record by ID.
     *
     * @param custId The ID of the basket record to retrieve.
     * @return The retrieved Basket object, or null if no record with the specified ID was found.
     */
    public Basket getBasketById(Long custId) {
        return basketRepository.findById(custId).orElse(null);
    }

    /**
     * Returns a list of all baskets in the database.
     *
     * @return a list of all baskets in the database
     */
    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }


    /**
     * Creates a new basket record.
     *
     * @param basket The Basket object representing the new basket record.
     * @return The created Basket object.
     */
    public Basket createBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    /**
     * Updates an existing basket record.
     *
     * @param id The ID of the basket record to update.
     * @param updatedBasket The updated Basket object representing the new basket information.
     * @return The updated Basket object, or null if no record with the specified ID was found.
     */
    public Basket updateBasket(Long id, Basket updatedBasket) {
        Basket existingBasket = basketRepository.findById(id).orElse(null);
        if (existingBasket != null) {
            //existingBasket.setCustomerId(updatedBasket.getCustomerId());
            // concatenate to already existing list of products
            existingBasket.setProducts( updatedBasket.getProducts());
            existingBasket.setTotalPrice( updatedBasket.getTotalPrice());
           return basketRepository.save(existingBasket);
        }
        return null;
    }

    /**
     * Deletes an existing basket record.
     *
     * @param id The ID of the basket record to delete.
     */
    public void deleteBasket(Long id) {
        basketRepository.deleteById(id);
    }

}
