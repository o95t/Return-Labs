package com.tobedeveloper.connecttomysql.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobedeveloper.connecttomysql.model.Book;
import com.tobedeveloper.connecttomysql.service.BookService;
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/search/author")
    public List<Book> searchBooksByAuthor(@RequestParam String author) {
        return bookService.searchBooksByAuthor(author);
    }

    @GetMapping("/search/category")
    public List<Book> searchBooksByCategory(@RequestParam String category) {
        return bookService.searchBooksByCategory(category);
    }

    @GetMapping("/search/title")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }
    
    // Other book-related API endpoints
}
