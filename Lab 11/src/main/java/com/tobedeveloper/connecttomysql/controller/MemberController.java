package com.tobedeveloper.connecttomysql.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.tobedeveloper.connecttomysql.model.Member;
import com.tobedeveloper.connecttomysql.service.CheckoutService;
import com.tobedeveloper.connecttomysql.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
	private final MemberService memberService;
	private final CheckoutService checkoutService;

	public MemberController(MemberService memberService, CheckoutService checkoutService) {
		this.memberService = memberService;
		this.checkoutService = checkoutService;
	}

	@PostMapping
	public Member addMember(@RequestBody Member member) {
		return memberService.addMember(member);
	}

	@GetMapping("/search/name")
	public List<Member> searchMembersByName(@RequestParam String name) {
		return memberService.searchMembersByName(name);
	}

	@GetMapping("/search/phone")
	public List<Member> searchMembersByPhoneNumber(@RequestParam String phoneNumber) {
		return memberService.searchMembersByPhoneNumber(phoneNumber);
	}

	@GetMapping("/{memberId}/overdue-amount")
	public double getOverdueAmount(@PathVariable Long memberId) {
		LocalDate currentDate = LocalDate.now();
		return checkoutService.calculateOverdueAmount(memberId, currentDate);
	}

	// Other member-related API endpoints
}
