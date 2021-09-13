package com.csci318.onlineorder.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csci318.onlineorder.models.*;
import com.csci318.onlineorder.repositories.*;
import com.csci318.onlineorder.services.OrderService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    //find all orders
    @GetMapping("/orders")
    CollectionModel<EntityModel<Order>> all() {
        return orderService.all();
    }

    //create new order
    @PostMapping("/orders")
    Order newOrder(@RequestBody Order newOrder) {
        return orderService.newOrder(newOrder);
    }

    //find order by id
    @GetMapping("/orders/{id}")
    EntityModel<Order> one(@PathVariable Long id) {
        return orderService.one(id);
    }

    //update order by id
    @PutMapping("/orders/{id}")
    Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id) {
        return orderService.replaceOrder(newOrder, id);
    }

    //delete order by id
    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}