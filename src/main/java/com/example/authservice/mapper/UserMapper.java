package com.example.authservice.mapper;

import com.example.authservice.database.entity.User;
import com.example.authservice.dto.UserInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "userRoles.role", target = "")
    UserInfoDto toDto(User user);
}
