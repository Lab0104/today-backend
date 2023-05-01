package com.example.jpaself.service;

import com.example.jpaself.data.domain.User;
import com.example.jpaself.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    
    @Transactional
    public String join(User user) {
        validateDuplicateMember(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(User user) {
        //exception
        List<User> findUser = userRepository.findId(user.getId());
        if(!findUser.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 전체 회원 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findOne(String userId) {
        return userRepository.findOne(userId);
    }

    @Transactional
    public void update(String id, String email) {
        User user = userRepository.findOne(id);
        user.setEmail(email);
    }
}
