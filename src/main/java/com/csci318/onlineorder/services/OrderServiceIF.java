package com.csci318.onlineorder.services;

import com.csci318.onlineorder.models.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;


public interface OrderServiceIF
{
    public abstract CollectionModel<EntityModel<Order>> all();
    public abstract Order newOrder(Order newOrder);
    public abstract EntityModel<Order> one(Long id);
    public abstract Order replaceOrder(Order newOrder,Long id);
    public abstract void deleteOrder(Long id);
}
