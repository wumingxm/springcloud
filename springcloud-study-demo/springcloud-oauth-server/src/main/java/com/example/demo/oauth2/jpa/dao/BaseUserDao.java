package com.example.demo.oauth2.jpa.dao;

import com.example.demo.oauth2.domain.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseUserDao<UserVO>  extends JpaRepository<BaseUser,Integer> {

    public BaseUser findByUserName(String userName);
}
