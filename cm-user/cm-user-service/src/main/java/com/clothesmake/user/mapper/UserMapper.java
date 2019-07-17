package com.clothesmake.user.mapper;

import com.clothesmake.user.dao.entity.UserEntity;
import com.clothesmake.user.dto.UserDto;
import com.clothesmake.user.qualifier.UserTrans;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserTrans.class )
public interface UserMapper {

    @Mapping(target = "roles", qualifiedByName = { "UserTrans", "RolesToList" })
    @Mapping(target = "smallavatar", qualifiedByName = { "UserTrans", "AvatarUrl" })
    @Mapping(target = "mediumavatar", qualifiedByName = { "UserTrans", "AvatarUrl" })
    @Mapping(target = "bigavatar", qualifiedByName = { "UserTrans", "AvatarUrl" })
    UserDto userToUserDto(UserEntity user);

}
