package com.example.jpaself.repository;

import com.example.jpaself.data.domain.mapping.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {

}
