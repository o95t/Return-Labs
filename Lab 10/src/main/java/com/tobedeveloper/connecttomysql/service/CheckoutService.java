package com.tobedeveloper.connecttomysql.service;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tobedeveloper.connecttomysql.model.Book;
import com.tobedeveloper.connecttomysql.model.Checkout;
import com.tobedeveloper.connecttomysql.model.Member;
import com.tobedeveloper.connecttomysql.repository.BookRepository;
import com.tobedeveloper.connecttomysql.repository.CheckoutRepository;
import com.tobedeveloper.connecttomysql.repository.MemberRepository;

//CheckoutService.java
@Service
public class CheckoutService {
	private final CheckoutRepository checkoutRepository;
	private final MemberRepository memberRepository;

	public CheckoutService(CheckoutRepository checkoutRepository, MemberRepository memberRepository) {
		this.checkoutRepository = checkoutRepository;
		this.memberRepository = memberRepository;
	}

	public Checkout checkoutBook(Checkout checkout) {
		return checkoutRepository.save(checkout);
	}

	public List<Checkout> getCheckedOutBooks() {
		return checkoutRepository.findAll();
	}

	public List<Checkout> getBooksBorrowedByMember(Long memberId) {
		return checkoutRepository.findByMemberId(memberId);
	}

	public List<Checkout> getOverdueCheckouts(LocalDate currentDate) {
		return checkoutRepository.findByDueDateBefore(currentDate);
	}

	public double calculateOverdueAmount(Long memberId, LocalDate currentDate) {
		List<Checkout> overdueCheckouts = checkoutRepository.findByMemberId(memberId).stream()
				.filter(checkout -> checkout.getDueDate().isBefore(currentDate)).collect(Collectors.toList());

		double overdueAmount = 0.0;

		for (Checkout checkout : overdueCheckouts) {
			long daysOverdue = ChronoUnit.DAYS.between(checkout.getDueDate(), currentDate);

			if (daysOverdue > 0) {
				double overdueFee = 0.0;
				if (isSeniorCitizen(memberId)) {
					overdueFee = daysOverdue * 0.05; // Senior citizens pay 5 cents per day
				} else if (isLibraryStaff(memberId)) {
					overdueFee = daysOverdue * 0.10; // Library staff pay 10 cents per day
				} else {
					overdueFee = daysOverdue * 0.25; // Standard members pay 25 cents per day
				}
				overdueAmount += overdueFee;
			}
		}

		Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));

		member.setOverdueAmount(overdueAmount);
		memberRepository.save(member);

		return overdueAmount;
	}

	private boolean isSeniorCitizen(Long memberId) {
	    Member member = memberRepository.findById(memberId)
	        .orElseThrow(() -> new RuntimeException("Member not found"));
	    if(member.getRole() == 'S') {
	    	return true;
	    }
	    
	    return false;
	  
	}

	private boolean isLibraryStaff(Long memberId) {
	    Member member = memberRepository.findById(memberId)
	        .orElseThrow(() -> new RuntimeException("Member not found"));
	    
	    // Assuming there is a flag or role-based check to identify library staff members
	    if(member.getRole() == 'L') {
	    	return true;
	    }
	    
	    return false;
	}
	// Other checkout-related operations

}
