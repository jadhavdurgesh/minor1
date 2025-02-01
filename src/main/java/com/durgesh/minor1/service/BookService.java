package com.durgesh.minor1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgesh.minor1.model.Author;
import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.repository.AuthorRepository;
import com.durgesh.minor1.repository.BookRepository;
import com.durgesh.minor1.request.BookCreateRequest;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Book createBook(BookCreateRequest request) {
        Author authorFromDB = authorRepository.findByEmail(request.getAuthorEmail());

        if (authorFromDB == null) {
            authorFromDB = authorRepository.save(request.toAuthor());
        }

        Book book = request.toBook();
        
       
        return bookRepository.save(book);
    }

}
