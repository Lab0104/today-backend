package com.example.jpaself.controller;

import com.example.jpaself.data.domain.User;
import com.example.jpaself.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
        user.setId(request.getId());

        String id = userService.join(user);
        return new CreateUserResponse(id);
    }

    @PutMapping("/api/users/{id}")
    public UpdateUserResponse updateUser(
            @PathVariable("id") String id,
            @RequestBody UpdateUserRequest request) {

        userService.update(id, request.getEmail());
        User findUser = userService.findOne(id);
        return new UpdateUserResponse(findUser.getId(), findUser.getEmail());
    }

    @Data
    static class UpdateUserRequest {
        private String email;
    }

    @Data
    @AllArgsConstructor
    static class UpdateUserResponse {
        private String id;
        private String email;
    }

    @Data
    static class CreateUserRequest {
        private String id;
    }
    @Data
    @AllArgsConstructor
    static class CreateUserResponse {
        private String id;
    }

}
