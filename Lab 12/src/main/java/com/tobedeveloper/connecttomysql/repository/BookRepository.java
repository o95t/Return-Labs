package com.tobedeveloper.connecttomysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobedeveloper.connecttomysql.model.Book;

//BookRepository.java
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
 List<Book> findByAuthor(String author);
 List<Book> findByCategory(String category);
 List<Book> findByTitleContaining(String title);
}
