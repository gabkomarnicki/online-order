package com.csci318.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csci318.order.models.*;
import com.csci318.order.services.OrderService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //find all orders
    @GetMapping("/orders")
    CollectionModel<EntityModel<Orders>> all() {
        return orderService.all();
    }

    //create new order
    @PostMapping("/orders")
    Orders createOrder(@RequestBody Orders createOrders) {
        return orderService.createOrder(createOrders);
    }

    //find order by id
    @GetMapping("/orders/{id}")
    EntityModel<Orders> one(@PathVariable Long id) {
        return orderService.one(id);
    }

    //update order by id
    @PutMapping("/orders/{id}")
    Orders replaceOrder(@RequestBody Orders createOrders, @PathVariable Long id) {
        return orderService.replaceOrder(createOrders, id);
    }

    //delete order by id
    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}