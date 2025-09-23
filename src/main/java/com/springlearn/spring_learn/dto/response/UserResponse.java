package com.springlearn.spring_learn.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;

    String username;

    String password;

    String firstName;

    String lastName;

    LocalDate dob;
}
