package com.example.authservice.mapper;

import com.example.authservice.database.entity.User;
import com.example.authservice.dto.UserCreateDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {RoleStringMapper.class})
public interface UserCreateMapper extends BaseMapper<User, UserCreateDto>{

    @AfterMapping
    default void setUserRoles(@MappingTarget User user) {
        if (user.getUserRoles() != null) {
            user.getUserRoles().forEach(role -> {
                role.setUser(user);
            });
        }
    }
}
