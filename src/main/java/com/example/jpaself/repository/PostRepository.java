package com.example.jpaself.repository;

import com.example.jpaself.data.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
