package com.csci318.onlinestore.repositories;

import com.csci318.onlinestore.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {}

