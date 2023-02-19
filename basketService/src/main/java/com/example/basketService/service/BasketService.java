package com.example.basketService.service;

import com.example.basketService.entity.Basket;
import com.example.basketService.entity.ProductItem;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final RestTemplate restTemplate;

    /**
     * Constructor for the BasketService class.
     *
     * @param basketRepository the repository for accessing basket data
     * @param restTemplate the REST client for accessing external services
     */
    public BasketService(BasketRepository basketRepository, RestTemplate restTemplate) {
        this.basketRepository = basketRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Creates a new basket.
     *
     * @return the created basket
     */
    public Basket createBasket() {
        Basket basket = new Basket();
        basketRepository.create(basket);
        return basket;
    }

    /**
     * Gets a basket with the specified ID.
     *
     * @param id the ID of the basket to retrieve
     * @return the retrieved basket
     */
    public Basket getBasket(Long id) {
        return basketRepository.findById(id);
    }

    /**
     * Adds a product to a basket.
     *
     * @param basketId the ID of the basket to add the product to
     * @param productId the ID of the product to add to the basket
     * @param quantity the quantity of the product to add to the basket
     */
    public void addProductToBasket(Long basketId, Long productId, int quantity) {
        Basket basket = basketRepository.findById(basketId);
        List<ProductItem> products = basket.getProducts();

        for (ProductItem product : products) {
            if (product.getProductId().equals(productId)) {
                // If the product already exists in the basket, update the quantity and total price
                int newQuantity = product.getQuantity() + quantity;
                double newTotalPrice = newQuantity * getProductPrice(productId);
                product.setQuantity(newQuantity);
                product.setTotalPrice(newTotalPrice);
                basketRepository.update(basket);
                return;
            }
        }

        // If the product does not exist in the basket, create a new ProductItem and add it to the basket
        double price = getProductPrice(productId);
        double totalPrice = quantity * price;
        ProductItem productItem = new ProductItem(productId, quantity, totalPrice);
        products.add(productItem);
        basketRepository.update(basket);
    }

    /**
     * Removes a product from a basket.
     *
     * @param basketId the ID of the basket to remove the product from
     * @param productId the ID of the product to remove from the basket
     */
    public void removeProductFromBasket(Long basketId, Long productId) {
        Basket basket = basketRepository.findById(basketId);
        List<ProductItem> products = basket.getProducts();

        for (ProductItem product : products) {
            if (product.getProductId().equals(productId)) {
                products.remove(product);
                basketRepository.update(basket);
                return;
            }
        }
    }

    /**
     * Updates the quantity and total price of a product in the basket with the given basket ID and product ID.
     * If the product does not exist in the basket, nothing happens.
     *
     * @param basketId the ID of the basket to update
     * @param productId the ID of the product to update
     * @param quantity the new quantity of the product
     */
    public void updateProductInBasket(Long basketId, Long productId, int quantity) {
        Basket basket = basketRepository.findById(basketId);
        List<ProductItem> products = basket.getProducts();

        // Update the quantity and total price of the product if it already exists in the basket
        for (ProductItem product : products) {
            if (product.getProductId().equals(productId)) {
                double price = getProductPrice(productId);
                double totalPrice = quantity * price;
                product.setQuantity(quantity);
                product.setTotalPrice(totalPrice);
                basketRepository.update(basket);
                return;
            }
        }
    }


    /**
     * Gets the total price of the basket with the given ID.
     *
     * @param basketId the ID of the basket to get the total price for
     * @return the total price of the basket
     */
    public double getTotalPrice(Long basketId) {
        Basket basket = basketRepository.findById(basketId);
        return basket.getTotalPrice();
    }


    // Get the price of a product with the given ID from the price service
    /**
     * Gets the price of a product with the given ID from the price service.
     *
     * @param productId the ID of the product to get the price for
     * @return the price of the product
     */
    private double getProductPrice(Long productId) {
        // Implement code to get the price of a product with the given ID from the price service
        /* String url = "http://localhost:8080/price/" + productId;
        double price = restTemplate.getForObject(url, Double.class);
        return price;*/
        return 0.0;
    }

}
