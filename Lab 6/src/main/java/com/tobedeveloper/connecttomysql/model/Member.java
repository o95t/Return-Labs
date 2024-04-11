package com.tobedeveloper.connecttomysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Member.java
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	private String name;
	private String address;
	private String phoneNumber;
	private String feeOptions;
	private double overdueAmount;
	private char role;
	
	
	
	public Member() {
		
	}




	public Member(Long memberId, String name, String address, String phoneNumber, String feeOptions,
			double overdueAmount, char role) {
		this.memberId = memberId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.feeOptions = feeOptions;
		this.overdueAmount = overdueAmount;
		this.role = role;
	}
	
	
	
	
	public char getRole() {
		return role;
	}
	public void setRole(char role) {
		this.role = role;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFeeOptions() {
		return feeOptions;
	}
	public void setFeeOptions(String feeOptions) {
		this.feeOptions = feeOptions;
	}
	public double getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(double overdueAmount) {
		this.overdueAmount = overdueAmount;
	}

	
	
}