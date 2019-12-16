package com.clothesmake.user.mapper;

import com.clothesmake.user.dao.entity.UserEntity;
import com.clothesmake.user.dto.UserDto;
import com.clothesmake.user.qualifier.UserTrans;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserTrans.class )
public interface UserMapper {

    @Mapping(target = "roles", qualifiedByName = { "UserTrans", "rolesToList" })
    @Mapping(target = "smallAvatar", qualifiedByName = { "UserTrans", "avatarUrl" })
    @Mapping(target = "mediumAvatar", qualifiedByName = { "UserTrans", "avatarUrl" })
    @Mapping(target = "bigAvatar", qualifiedByName = { "UserTrans", "avatarUrl" })
    UserDto userToUserDto(UserEntity user);

}
