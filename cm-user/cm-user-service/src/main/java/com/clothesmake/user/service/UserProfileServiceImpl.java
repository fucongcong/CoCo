package com.clothesmake.user.service;

import com.clothesmake.user.api.UserProfileService;
import com.clothesmake.user.dao.entity.UserProfileEntity;
import com.clothesmake.user.dao.repository.UserProfileRepository;
import com.clothesmake.user.dto.UserProfileDto;
import com.clothesmake.user.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    protected UserProfileRepository userProfileRepository;

    @Autowired
    protected UserProfileMapper userProfileMapper;

    public UserProfileDto getUserProfile(int id) {
        UserProfileEntity userProfileEntity = userProfileRepository.findById(id).get();

        return  userProfileMapper.userProfileToUserProfileDto(userProfileEntity);
    }
}
