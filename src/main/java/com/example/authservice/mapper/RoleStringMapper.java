package com.example.authservice.mapper;

import com.example.authservice.database.entity.UserRoles;
import com.example.authservice.database.enumerated.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleStringMapper extends BaseMapper<UserRoles,String> {
    @Override
    default UserRoles toSource(String destination){
        return new UserRoles(Role.valueOf(destination.toUpperCase()));
    }

    @Override
    default String toDestination(UserRoles source){
        return source.getRole().toString();
    };
}
