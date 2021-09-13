package com.csci318.onlineorder.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import com.csci318.onlineorder.controllers.OrderNotFoundException;
import com.csci318.onlineorder.controllers.OrderModelAssembler;
import com.csci318.onlineorder.models.Order;
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
    public CollectionModel<EntityModel<Order>> all() {
        // TODO Auto-generated method stub
        List<EntityModel<Order>> orders = orderRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(orders,
                linkTo(methodOn(OrderService.class).all()).withSelfRel());
    }

    //create a new order
    @Override
    public Order newOrder(Order newOrder) {
        // TODO Auto-generated method stub
        return orderRepository.save(newOrder);
    }

    //find order information by id
    @Override
    public EntityModel<Order> one(Long id) {
        // TODO Auto-generated method stub
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        return assembler.toModel(order);
    }

    //update order
    @Override
    public Order replaceOrder(Order newOrder, Long id) {
        // TODO Auto-generated method stub
        return orderRepository.findById(id)
                .map(order -> {
                    order.setSupplier(newOrder.getSupplier());
                    order.setProduct(newOrder.getProduct());
                    order.setQuantity(newOrder.getQuantity());
                    return orderRepository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return orderRepository.save(newOrder);
                });
    }

    //delete order record
    @Override
    public void deleteOrder(Long id) {
        // TODO Auto-generated method stub
        orderRepository.deleteById(id);
    }
}