package com.csci318.onlineorder.services;

import com.csci318.onlineorder.models.Orders;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;


public interface OrderServiceIF
{
    public abstract CollectionModel<EntityModel<Orders>> all();
    public abstract Orders createOrder(Orders createOrders);
    public abstract EntityModel<Orders> one(Long id);
    public abstract Orders replaceOrder(Orders createOrders, Long id);
    public abstract void deleteOrder(Long id);
}
