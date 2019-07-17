package com.clothesmake.user.mapper;

import com.clothesmake.user.dao.entity.UserProfileEntity;
import com.clothesmake.user.dto.UserProfileDto;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    @InheritConfiguration
    UserProfileDto userProfileToUserProfileDto(UserProfileEntity userProfile);
}
