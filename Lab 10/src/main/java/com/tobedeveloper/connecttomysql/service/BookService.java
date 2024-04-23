package com.tobedeveloper.connecttomysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tobedeveloper.connecttomysql.model.Book;
import com.tobedeveloper.connecttomysql.repository.BookRepository;

// BookService.java
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> searchBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }
    
    // Other book-related operations
}
