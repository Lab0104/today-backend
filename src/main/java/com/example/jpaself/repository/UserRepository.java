package com.example.jpaself.repository;

import com.example.jpaself.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findId(String id);
    User findOne(String id);
}