package com.tobedeveloper.connecttomysql.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobedeveloper.connecttomysql.model.Checkout;
import com.tobedeveloper.connecttomysql.service.CheckoutService;

// CheckoutController.java
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	private final CheckoutService checkoutService;

	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}

	@PostMapping
	public Checkout checkoutBook(@RequestBody Checkout checkout) {
		return checkoutService.checkoutBook(checkout);
	}

	@GetMapping("/checked-out")
	public List<Checkout> getCheckedOutBooks() {
		return checkoutService.getCheckedOutBooks();
	}

	@GetMapping("/borrowed-by-member/{memberId}")
	public List<Checkout> getBooksBorrowedByMember(@PathVariable Long memberId) {
		return checkoutService.getBooksBorrowedByMember(memberId);
	}

	@GetMapping("/overdue")
	public List<Checkout> getOverdueCheckouts() {
		LocalDate currentDate = LocalDate.now();
		return checkoutService.getOverdueCheckouts(currentDate);
	}

	// Other checkout-related API endpoints
}