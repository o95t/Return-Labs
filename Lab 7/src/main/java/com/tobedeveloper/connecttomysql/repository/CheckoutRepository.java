package com.tobedeveloper.connecttomysql.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobedeveloper.connecttomysql.model.Checkout;


//CheckoutRepository.java
@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
	List<Checkout> findByMemberId(Long memberId);

	List<Checkout> findByDueDateBefore(LocalDate currentDate);
}