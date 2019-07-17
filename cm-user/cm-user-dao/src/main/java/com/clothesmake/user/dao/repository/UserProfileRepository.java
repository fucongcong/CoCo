package com.clothesmake.user.dao.repository;


import com.clothesmake.user.dao.entity.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Integer> {
}
