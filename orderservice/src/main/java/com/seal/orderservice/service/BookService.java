package com.seal.orderservice.service;

import com.seal.orderservice.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("book-service")
public interface BookService {

    @RequestMapping(method = RequestMethod.GET, value = "/books", consumes = "application/json")
    List<Book> getAllBooks();

}
