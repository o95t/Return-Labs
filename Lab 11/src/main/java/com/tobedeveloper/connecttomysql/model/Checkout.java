package com.tobedeveloper.connecttomysql.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Checkout.java
@Entity
public class Checkout {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long checkoutId;
	private Long bookId;
	private Long memberId;
	private LocalDate checkoutDate;
	private LocalDate dueDate;

	
	
	public Checkout() {
		
	}

	public Checkout(Long checkoutId, Long bookId, Long memberId, LocalDate checkoutDate, LocalDate dueDate) {
		this.checkoutId = checkoutId;
		this.bookId = bookId;
		this.memberId = memberId;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}

	public Long getCheckoutId() {
		return checkoutId;
	}

	public void setCheckoutId(Long checkoutId) {
		this.checkoutId = checkoutId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}