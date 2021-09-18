package com.csci318.onlineorder.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import com.csci318.onlineorder.models.Orders;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import com.csci318.onlineorder.controllers.OrderNotFoundException;
import com.csci318.onlineorder.controllers.OrderModelAssembler;
import com.csci318.onlineorder.repositories.OrderRepository;

@Service
public class OrderService implements OrderServiceIF
{
    private final OrderRepository orderRepository;
    private final OrderModelAssembler assembler;

    public OrderService(OrderRepository repository, OrderModelAssembler assembler) {
        this.orderRepository = repository;
        this.assembler = assembler;
    }

    //find all orders
    @Override
    public CollectionModel<EntityModel<Orders>> all() {
        // TODO Auto-generated method stub
        List<EntityModel<Orders>> orders = orderRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(orders,
                linkTo(methodOn(OrderService.class).all()).withSelfRel());
    }

    //create a new order
    @Override
    public Orders newOrder(Orders newOrders) {
        // TODO Auto-generated method stub
        return orderRepository.save(newOrders);
    }

    //find order information by id
    @Override
    public EntityModel<Orders> one(Long id) {
        // TODO Auto-generated method stub
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        return assembler.toModel(orders);
    }

    //update order
    @Override
    public Orders replaceOrder(Orders newOrders, Long id) {
        // TODO Auto-generated method stub
        return orderRepository.findById(id)
                .map(order -> {
                    order.setSupplier(newOrders.getSupplier());
                    order.setProduct(newOrders.getProduct());
                    order.setQuantity(newOrders.getQuantity());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrders.setId(id);
                    return orderRepository.save(newOrders);
                });
    }

    //delete order record
    @Override
    public void deleteOrder(Long id) {
        // TODO Auto-generated method stub
        orderRepository.deleteById(id);
    }
}