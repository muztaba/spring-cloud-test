package com.seal.bookservice.controller;

import com.seal.bookservice.dto.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<Book> getAll() {

        return List.of(new Book(1L, "Java"),
                new Book(2L, "Scala"),
                new Book(3L, "Clojure"));
    }

}
