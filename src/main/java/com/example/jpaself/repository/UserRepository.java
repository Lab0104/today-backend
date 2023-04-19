package com.example.jpaself.repository;

import com.example.jpaself.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}