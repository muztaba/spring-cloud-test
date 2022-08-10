package com.seal.orderservice.controller;

import com.seal.orderservice.dto.Book;
import com.seal.orderservice.dto.Order;
import com.seal.orderservice.service.BookService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final DiscoveryClient discoveryClient;
    private final BookService bookService;

    public OrderController(DiscoveryClient discoveryClient, BookService bookService) {
        this.discoveryClient = discoveryClient;
        this.bookService = bookService;
    }

    @GetMapping
    public List<Order> getAll() {

        return List.of(new Order(1L, UUID.randomUUID().toString()),
                new Order(2L, UUID.randomUUID().toString()),
                new Order(3L, UUID.randomUUID().toString()));
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        List<ServiceInstance> instances = discoveryClient.getInstances("book-service");

        return bookService.getAllBooks();
    }
}
