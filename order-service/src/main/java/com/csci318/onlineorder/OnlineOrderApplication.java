package com.csci318.onlineorder;

import com.csci318.onlineorder.models.OrdersValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OnlineOrderApplication {

    private static final Logger log = LoggerFactory.getLogger(OnlineOrderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OnlineOrderApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            OrdersValue order = restTemplate.getForObject("http://localhost:8181/orders/1", OrdersValue.class);
            //order.setProduct(product);

        };
    }
}
