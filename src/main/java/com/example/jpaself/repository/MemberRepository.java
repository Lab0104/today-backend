package com.example.jpaself.repository;

import com.example.jpaself.data.domain.mapping.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
