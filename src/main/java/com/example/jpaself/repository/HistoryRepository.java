package com.example.jpaself.repository;

import com.example.jpaself.data.domain.mapping.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
