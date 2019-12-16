package com.clothesmake.user.api;

import com.clothesmake.user.dao.entity.UserEntity;
import com.clothesmake.user.dto.UserDto;

public interface UserService {
    UserDto getUser(int id);

    public UserDto registerUser(UserDto userDto, String password);
}
