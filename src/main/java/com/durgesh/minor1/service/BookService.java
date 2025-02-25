package com.durgesh.minor1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.durgesh.minor1.model.Author;
import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.BookType;
import com.durgesh.minor1.model.FilterType;
import com.durgesh.minor1.model.Operator;
import com.durgesh.minor1.repository.AuthorRepository;
import com.durgesh.minor1.repository.BookRepository;
import com.durgesh.minor1.request.BookCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Book createBook(BookCreateRequest bookCreateRequest) {
        // check if the author coming from FE is already present in db or not

        // if not present, create a new author and then create a book

        // if present, create a book with the existing author
        Author authorFromDb = authorRepository.findByEmail(bookCreateRequest.getAuthorEmail());
        if (authorFromDb == null) {
            // create a row inside author table
            authorFromDb = authorRepository.save(bookCreateRequest.toAuthor());
        }

        // create a row inside book table
        Book book = bookCreateRequest.toBook();
        book.setAuthor(authorFromDb);

        return bookRepository.save(book);

    }

    public List<Book> filter(FilterType filterBy, Operator operator, String value) {
        switch (operator) {
            case EQUALS:
                switch (filterBy) {
                    case BOOK_NO:
                        return bookRepository.findByBookNo(value);
                    case AUTHOR_NAME:
                        return bookRepository.findByAuthorName(value);
                    case COST:
                        return bookRepository.findByCost(Integer.parseInt(value));
                    case BOOKTYPE:
                        return bookRepository.findByBookType(BookType.valueOf(value));
                }
            case LESS_THAN:
                switch (filterBy) {
                    case COST:
                        return bookRepository.findByCostLessThan(Integer.parseInt(value));
                    default:
                        break;

                }
            default:
                return new ArrayList<>();

        }
    }

}
