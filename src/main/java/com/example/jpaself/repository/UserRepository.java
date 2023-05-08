package com.example.jpaself.repository;

import com.example.jpaself.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findUsers();
    List<User> findByNickname(String nickname);
//    List<User> findNickname(String nickname);
}