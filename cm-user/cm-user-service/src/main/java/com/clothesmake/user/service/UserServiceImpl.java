package com.clothesmake.user.service;

import com.clothesmake.exception.ServiceException;
import com.clothesmake.user.api.UserService;
import com.clothesmake.user.dao.entity.UserEntity;
import com.clothesmake.user.dao.repository.UserRepository;
import com.clothesmake.user.dto.UserDto;
import com.clothesmake.user.mapper.UserMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    protected EntityManager entityManager;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserMapper userMapper;

    public UserDto getUser(int id) {
        UserEntity userEntity = userRepository.findById(id).get();

        return  userMapper.userToUserDto(userEntity);
    }

    public UserDto registerUser(UserDto userDto, String password) {
        userRepository.findOneByMobile(userDto.getMobile()).ifPresent(user -> {
            throw new ServiceException(1005, "手机号已被注册");
        });

        UserEntity userEntity = new UserEntity();
        userEntity.setMobile(userDto.getMobile());
        userEntity.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        userEntity.setSourceFrom(userDto.getSourceFrom());

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> roles = new ArrayList<>();
        roles.add("customer");
        try {
            userEntity.setRoles(objectMapper.writeValueAsString(roles));
        } catch (JsonProcessingException e) {
            throw new ServiceException("json 序列化错误");
        }

        userEntity.setCreateTime((int) (System.currentTimeMillis() / 1000));
        userEntity.setNickname("cm" + System.currentTimeMillis() / 1000);
        userRepository.save(userEntity);

        entityManager.refresh(userEntity);
        return userMapper.userToUserDto(userEntity);
    }
}
