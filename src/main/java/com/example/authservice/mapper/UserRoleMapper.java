package com.example.authservice.mapper;

import com.example.authservice.database.entity.User;
import com.example.authservice.dto.UserInfoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {RoleStringMapper.class})
public interface UserRoleMapper extends  BaseMapper<User, UserInfoDto> {
}
