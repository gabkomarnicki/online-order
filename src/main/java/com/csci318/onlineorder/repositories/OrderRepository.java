package com.csci318.onlineorder.repositories;

import com.csci318.onlineorder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}

