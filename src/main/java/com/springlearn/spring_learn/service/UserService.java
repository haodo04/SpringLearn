package com.springlearn.spring_learn.service;

import com.springlearn.spring_learn.dto.request.UserCreationRequest;
import com.springlearn.spring_learn.dto.request.UserUpdateRequest;
import com.springlearn.spring_learn.dto.response.UserResponse;
import com.springlearn.spring_learn.entity.User;
import com.springlearn.spring_learn.enums.Role;
import com.springlearn.spring_learn.exception.AppException;
import com.springlearn.spring_learn.exception.ErrorCode;
import com.springlearn.spring_learn.mapper.UserMapper;
import com.springlearn.spring_learn.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request) {
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return userMapper.toUserResponse(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers() {
        log.info("In method get Users");
        return userRepository.findAll();
    }

    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUser(Long id) {
        log.info("In method get user by id");
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
