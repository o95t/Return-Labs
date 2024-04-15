package com.tobedeveloper.connecttomysql.service;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.tobedeveloper.connecttomysql.model.Member;
import com.tobedeveloper.connecttomysql.repository.MemberRepository;
import com.tobedeveloper.connecttomysql.service.MemberService;
//MemberService.java
@Service
public class MemberService {
 private final MemberRepository memberRepository;

 public MemberService(MemberRepository memberRepository) {
     this.memberRepository = memberRepository;
 }

 public Member addMember(Member member) {
     return memberRepository.save(member);
 }

 public List<Member> searchMembersByName(String name) {
     return memberRepository.findByName(name);
 }

 public List<Member> searchMembersByPhoneNumber(String phoneNumber) {
     return memberRepository.findByPhoneNumber(phoneNumber);
 }
 
 // Other member-related operations
}
