package com.seal.orderservice.controller;

import com.seal.orderservice.dto.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public List<Order> getAll() {

        return List.of(new Order(1L, UUID.randomUUID().toString()),
                new Order(2L, UUID.randomUUID().toString()),
                new Order(3L, UUID.randomUUID().toString()));
    }

}
