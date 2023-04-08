package com.kbe2223.basketservice.consumer;

import com.kbe2223.basketservice.entity.Basket;
import com.kbe2223.basketservice.service.BasketService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @Autowired
    private BasketService basketService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        LOGGER.info(String.format("Received message -> %s", message));

        JSONObject jsonObject = new JSONObject(message);
        LOGGER.info(String.format("Converted JSON -> %s", jsonObject));

        Long _id = jsonObject.getLong("customerId");
        Double _totalPrice = jsonObject.getDouble("totalPrice");
        String _products = jsonObject.getString("products");

        Basket _basket = new Basket(_totalPrice, _products, _id);

        Basket updatedBasket = basketService.updateBasket(_id, _basket);
    }
}

