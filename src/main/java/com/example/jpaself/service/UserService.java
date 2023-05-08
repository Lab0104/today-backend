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
        return user.getNickname();
    }

    private void validateDuplicateMember(User user) {
        //exception
        List<User> findUser = userRepository.findByNickname(user.getNickname());
        if(!findUser.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 전체 회원 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findOne(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        User userInfo = user.get();
        return userInfo;
    }

    @Transactional
    public void update(Long userId, String email, String password) {
        Optional<User> user = userRepository.findById(userId);
        User userInfo = user.get();
        userInfo.setEmail(email);
        userInfo.setPasswordKey(password);
    } // 이메일, 비밀번호, 주소 변경
}
