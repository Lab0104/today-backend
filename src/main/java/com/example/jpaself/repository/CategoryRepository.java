package com.example.jpaself.repository;

import com.example.jpaself.data.domain.component.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
