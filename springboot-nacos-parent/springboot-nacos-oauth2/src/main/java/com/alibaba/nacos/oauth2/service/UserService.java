package com.alibaba.nacos.service;

import com.alibaba.nacos.api.dao.UserDao;
import com.alibaba.nacos.api.domain.User;
import com.alibaba.nacos.api.pojo.JWT;
import com.alibaba.nacos.api.util.BPwdEncoderUtil;
import com.alibaba.nacos.feign.client.UserServiceFeign;
import com.alibaba.nacos.dto.UserDto;
import com.alibaba.nacos.dto.UserLoginDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private UserServiceFeign client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  =  userRepository.findByUsername(username);
        return user;
    }
    public UserLoginDto  login(String username, String password){
        User user= userRepository.findByUsername(username);
        if(user==null){
            throw new RuntimeException("用户不存在");
        }
        if(!BPwdEncoderUtil.matches(password, user.getPassword())){
            throw new RuntimeException("用户密码不对");
        }
        //dXNlci1zZXJ2aWNlOjEyMzQ1Ng== 是 user-service:123456的 base64编码
        JWT jwt =client.getToken("dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, password);
        if(jwt==null){
            throw new RuntimeException("用户Token有问题");
        }
        UserLoginDto dto = new UserLoginDto();
        dto.setUser(user);
        dto.setJwt(jwt);
        return dto;
    }

    public void save(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userRepository.save(user);
    }

}
