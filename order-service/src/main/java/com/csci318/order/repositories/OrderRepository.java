package com.csci318.order.repositories;

import com.csci318.order.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {}

