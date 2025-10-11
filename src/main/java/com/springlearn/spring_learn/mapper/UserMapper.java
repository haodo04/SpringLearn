package com.springlearn.spring_learn.mapper;

import com.springlearn.spring_learn.dto.request.UserCreationRequest;
import com.springlearn.spring_learn.dto.request.UserUpdateRequest;
import com.springlearn.spring_learn.dto.response.UserResponse;
import com.springlearn.spring_learn.entity.Role;
import com.springlearn.spring_learn.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);
    // use MappingTarget to define request to user
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
