package com.durgesh.minor1.request;

import com.durgesh.minor1.model.Author;
import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.BookType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreateRequest {
    private String name;

    private String bookNo;

    private int cost;

    private BookType type;

    private String authorName;

    private String authorEmail;

    public Author toAuthor() {
        return Author.builder().name(this.authorName).email(this.authorEmail).build();
    }

    public Book toBook() {
        return Book.builder().name(this.name).bookNo(this.bookNo).cost(this.cost).type(this.type)
                .author(this.toAuthor()).build();
    }

}
