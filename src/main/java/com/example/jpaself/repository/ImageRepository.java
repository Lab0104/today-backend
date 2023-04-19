package com.example.jpaself.repository;

import com.example.jpaself.domain.component.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
