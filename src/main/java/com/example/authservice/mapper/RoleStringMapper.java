package com.example.authservice.mapper;

import com.example.authservice.database.entity.UserRoles;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleStringMapper extends BaseMapper<UserRoles,String> {
    @Override
    default UserRoles toSource(String destination){
        throw new UnsupportedOperationException();
    }

    @Override
    default String toDestination(UserRoles source){
        return source.getRole().toString();
    };
}
