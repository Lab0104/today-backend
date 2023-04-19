package com.example.jpaself.repository;

import com.example.jpaself.domain.Meet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetRepository extends JpaRepository<Meet, String> {
}

