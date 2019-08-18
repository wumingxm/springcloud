package com.example.demo.oauth2.service;

import com.example.demo.oauth2.jpa.dao.BaseUserDao;
import com.example.demo.oauth2.domain.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseUserService {

    @Autowired
    private BaseUserDao baseUserDao;

    public void  saveUser(BaseUser baseUser){
        baseUserDao.save(baseUser);
    }
}
