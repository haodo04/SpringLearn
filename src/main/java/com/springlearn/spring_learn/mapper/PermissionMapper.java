package com.springlearn.spring_learn.mapper;

import com.springlearn.spring_learn.dto.request.PermissionRequest;
import com.springlearn.spring_learn.dto.response.PermissionResponse;
import com.springlearn.spring_learn.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
