package com.example.authservice.mapper;

import com.example.authservice.database.entity.User;
import com.example.authservice.dto.UserCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleStringMapper.class})
public interface UserCreateMapper extends BaseMapper<User, UserCreateDto>{
}
