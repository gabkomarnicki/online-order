package com.csci318.onlineorder.services;

import com.csci318.onlineorder.models.Orders;
import com.csci318.onlineorder.repositories.OrderRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventHandler {

    private final OrderRepository orderRepository;

    public OrderEventHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @EventListener
    public void handle(Orders orders) {
        orderRepository.save(orders);
    }
}
