package com.clothesmake.user.service;

import com.clothesmake.user.api.UserService;
import com.clothesmake.user.dao.entity.UserEntity;
import com.clothesmake.user.dao.repository.UserRepository;
import com.clothesmake.user.dto.UserDto;
import com.clothesmake.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserMapper userMapper;

    public UserDto getUser(int id) {
        UserEntity userEntity = userRepository.findById(id).get();

        return  userMapper.userToUserDto(userEntity);
    }
}
