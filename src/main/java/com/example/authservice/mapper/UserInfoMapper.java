package com.example.authservice.mapper;

import com.example.authservice.database.entity.User;
import com.example.authservice.dto.UserInfoDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {UserRoleMapper.class})
public interface UserInfoMapper extends BaseMapper<User, UserInfoDto> {
}
