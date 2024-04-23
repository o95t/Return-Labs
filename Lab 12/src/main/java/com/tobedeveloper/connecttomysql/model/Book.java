package com.tobedeveloper.connecttomysql.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Book.java
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String description;
	private String location;
	private String category;

	
	
	public Book() {

	}
	
	
	 @JsonCreator
	    public Book(@JsonProperty("title") String title, @JsonProperty("author") String author) {
	        this.title = title;
	        this.author = author;
	    }


	public Book(Long bookId, String isbn, String title, String author, String publisher, String description,
			String location, String category) {
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.description = description;
		this.location = location;
		this.category = category;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}