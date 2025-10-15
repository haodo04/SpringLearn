package com.springlearn.spring_learn.service;

import com.springlearn.spring_learn.dto.request.UserCreationRequest;
import com.springlearn.spring_learn.dto.response.UserResponse;
import com.springlearn.spring_learn.entity.User;
import com.springlearn.spring_learn.exception.AppException;
import com.springlearn.spring_learn.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepository;

    private UserCreationRequest request;
    private UserResponse userResponse;
    private User user;
    private LocalDate dob;

    @BeforeEach
    void initDate() {
        dob = LocalDate.of(1990, 1, 1);

        request = UserCreationRequest.builder()
                .username("john")
                .firstName("Doe")
                .lastName("John")
                .password("11111111")
                .dob(dob)
                .build();

        userResponse = UserResponse.builder()
                .id(20L)
                .username("john")
                .firstName("Doe")
                .lastName("John")
                .dob(dob)
                .build();

        user = User.builder()
                .id(20L)
                .username("john")
                .firstName("Doe")
                .lastName("John")
                .dob(dob)
                .build();
    }

    @Test
    void createUser_valid_request() {
        // given
        when(userRepository.existsByUsername(anyString())).thenReturn(false);
        when(userRepository.save(any())).thenReturn(user);

        // when
        var response = userService.createUser(request);

        // then
        Assertions.assertThat(response.getId()).isEqualTo(20L);
        Assertions.assertThat(response.getUsername()).isEqualTo("john");
    }

    @Test
    void createUser_userExisted_fail() {
        // given
        when(userRepository.existsByUsername(anyString())).thenReturn(true);

        // when
        var exception = assertThrows(AppException.class,
                () -> userService.createUser(request));

        // then
        Assertions.assertThat(exception.getErrorCode().getCode()).isEqualTo(1002);
    }
}
