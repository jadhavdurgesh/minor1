package com.durgesh.minor1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.request.BookCreateRequest;
import com.durgesh.minor1.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    
    @PostMapping("/create")
    public Book createBook(@RequestBody BookCreateRequest request) {
        return bookService.createBook(request);
        
    }
    
}
