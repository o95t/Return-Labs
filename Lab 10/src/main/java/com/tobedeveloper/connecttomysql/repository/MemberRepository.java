package com.tobedeveloper.connecttomysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tobedeveloper.connecttomysql.model.Member;

// MemberRepository.java
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
}
