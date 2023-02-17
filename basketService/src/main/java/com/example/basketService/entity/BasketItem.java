package com.example.basketService.entity;


import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "basket_item")
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;


    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    private String currency;

    /**
     * Gets the basket to which this basket item belongs.
     *
     * @return The basket to which this basket item belongs.
     */
    public Basket getBasket() {
        return basket;
    }

    /**
     * Sets the basket to which this basket item belongs.
     *
     * @param basket The basket to which this basket item belongs.
     */
    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    /**
     * Gets the ID of this basket item.
     *
     * @return The ID of this basket item.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of this basket item.
     *
     * @param id The ID of this basket item.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the ID of the product associated with this basket item.
     *
     * @return The ID of the product associated with this basket item.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product associated with this basket item.
     *
     * @param productId The ID of the product associated with this basket item.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets the quantity of this basket item.
     *
     * @return The quantity of this basket item.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this basket item.
     *
     * @param quantity The quantity of this basket item.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the price of this basket item.
     *
     * @return The price of this basket item.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of this basket item.
     *
     * @param price The price of this basket item.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the currency code for the price of this basket item.
     *
     * @return The currency code for the price of this basket item.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency code for the price of this basket item.
     *
     * @param currency The currency code for the price of this basket item.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
