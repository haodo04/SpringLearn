package com.springlearn.spring_learn.mapper;

import com.springlearn.spring_learn.dto.request.UserCreationRequest;
import com.springlearn.spring_learn.dto.request.UserUpdateRequest;
import com.springlearn.spring_learn.dto.response.UserResponse;
import com.springlearn.spring_learn.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    @Mapping(target = "username", source = "username")
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
