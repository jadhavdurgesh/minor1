package com.durgesh.minor1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.FilterType;
import com.durgesh.minor1.model.Operator;
import com.durgesh.minor1.request.BookCreateRequest;
import com.durgesh.minor1.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public Book createBook(@RequestBody BookCreateRequest request) {
        return bookService.createBook(request);
    }

    @GetMapping("/filter")
    public List<Book> filter(@RequestParam("filterBy") FilterType filterBy, @RequestParam("operator") Operator operator,
            @RequestParam("value") String value) {
        return bookService.filter(filterBy, operator, value);
    }
}
