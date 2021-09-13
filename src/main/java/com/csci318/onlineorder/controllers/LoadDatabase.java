package com.csci318.onlineorder.controllers;

import com.csci318.onlineorder.models.Order;
import com.csci318.onlineorder.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    //loading database with data
    @Bean
    CommandLineRunner initDB(OrderRepository orderRepository) {
        return args -> {
            log.info("Loading... " + orderRepository.save(new Order("ABC Supplier", "microwave", "20")));
            log.info("Loading... " + orderRepository.save(new Order("FedEx", "microprocessor", "90")));
            log.info("Loading..." + orderRepository.save(new Order("ACME Delivery", "dishwasher", "70")));
        };
    }
}
