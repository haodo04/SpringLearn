package com.springlearn.spring_learn.mapper;

import com.springlearn.spring_learn.dto.request.RoleRequest;
import com.springlearn.spring_learn.dto.response.RoleResponse;
import com.springlearn.spring_learn.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
