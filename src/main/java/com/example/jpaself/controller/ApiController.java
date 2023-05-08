package com.example.jpaself.controller;

import com.example.jpaself.data.domain.User;
import com.example.jpaself.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<User> UserList() {
        return userService.findUsers();
    }

    @PostMapping("/api/users")
    public CreateUserResponse saveUser(@RequestBody CreateUserRequest request) {
        User user = new User();
        user.setNickname(request.getNickname());
        user.setEmail(request.getEmail());
        user.setPasswordKey(request.getPassword());
        user.setLoginMethod(request.getLoginMethod());
        user.setAddress(request.getAddress());
        user.setAddressLatitude(request.getAddressLatitude());
        user.setAddressLongitude(request.getAddressLongitude());

        String name = userService.join(user);
        return new CreateUserResponse(name);
    } // id 번호로 조회를 해서 없으면 에러, getmapping에서 정보를 다 읽으니까 response 1개 해도 노상관

    @PutMapping("/api/users/{id}")
    public UpdateUserResponse updateUser(
            @PathVariable("id") Long id,
            @RequestBody UpdateUserRequest request) {

        userService.update(id, request.getEmail(), request.getPassword());
        User findUser = userService.findOne(id);
        return new UpdateUserResponse(findUser.getNickname(), findUser.getEmail());
    }

//    @GetMapping("/api/users/test/{id}")
//    public
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> userEntity(
            @PathVariable("id") Long id,
            @RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Data
    static class UpdateUserRequest {
        private String email;
        private String address;
        private String password;
        private double addressLatitude;
        private double addressLongitude;
    } // 이메일, 주소, 비밀번호

    @Data
    @AllArgsConstructor
    static class UpdateUserResponse {
        private String nickname;
        private String email;
    } // 이메일, 주소, 비밀번호

    @Data
    static class CreateUserRequest {
        private String email;
        private String nickname;
        private String password;
        private String loginMethod;
        private String Address;
        private double addressLatitude;
        private double addressLongitude;
    } // 이메일, 닉네임, 비밀번호, 주소, 로그인 방식
    // 위도, 경도
    @Data
    @AllArgsConstructor
    static class CreateUserResponse {
        private String nickname;
    } // 닉네임, 주소

}
