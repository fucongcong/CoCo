package com.clothesmake.user.api;

import com.clothesmake.user.dto.UserProfileDto;

public interface UserProfileService {
    UserProfileDto getUserProfile(int id);
}
