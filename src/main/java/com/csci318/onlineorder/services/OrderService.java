package com.csci318.onlineorder.services;

import com.csci318.onlineorder.models.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    public abstract CollectionModel<EntityModel<Order>> all();
    public abstract ResponseEntity<?> newOrder(Order newOrder);
    public abstract EntityModel<Order> one(Long id);
    public abstract ResponseEntity<?> replaceOrder(Order newOrder,Long id);
    public abstract ResponseEntity<?> deleteOrder(Long id);
}
