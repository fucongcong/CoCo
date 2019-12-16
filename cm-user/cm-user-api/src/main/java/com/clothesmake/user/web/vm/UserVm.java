package com.clothesmake.user.web.vm;

import com.clothesmake.user.dto.UserDto;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserVm extends UserDto {

    public static final int PASSWORD_MIN_LENGTH = 6;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)

    private String password;
}
