package com.springlearn.spring_learn.controller;

import com.springlearn.spring_learn.DTO.request.UserCreationRequest;
import com.springlearn.spring_learn.DTO.request.UserUpdateRequest;
import com.springlearn.spring_learn.entity.User;
import com.springlearn.spring_learn.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "user has been delete";
    }

}
