package com.example.demo.oauth2.service;

import com.example.demo.oauth2.jpa.dao.BaseRoleDao;
import com.example.demo.oauth2.jpa.dao.BaseUserDao;
import com.example.demo.oauth2.domain.BaseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BaseUserDetialService implements UserDetailsService {

        private Logger logger = LoggerFactory.getLogger(this.getClass());

        @Autowired
        private BaseUserDao baseUserDao;
        @Autowired
        private BaseRoleDao baseRoleDao;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           BaseUser baseUser =  baseUserDao.findByUserName(username);
           if(baseUser!=null){
             return baseUser;
           }else{
               throw new UsernameNotFoundException("用户名不存在");
           }
        }

        private boolean isActive(int active){
            return active == 1 ? true : false;
        }
    }

