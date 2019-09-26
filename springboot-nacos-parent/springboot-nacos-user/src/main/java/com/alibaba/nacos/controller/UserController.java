package com.alibaba.nacos.controller;

import com.alibaba.nacos.api.util.MessageResult;
import com.alibaba.nacos.api.vo.UserVo;
import com.alibaba.nacos.dto.UserDto;
import com.alibaba.nacos.dto.UserLoginDto;
import com.alibaba.nacos.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/regist")
    public MessageResult regist(@RequestBody UserVo user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        user.setPassword( passwordEncoder.encode(user.getPassword()));
        userService.save(userDto);
        return MessageResult.success().data(user);
    }

    @PostMapping("/login")
    public UserLoginDto login(@RequestBody  UserVo userVo){
        UserLoginDto userLoginDto = userService.login(userVo.getUsername(),userVo.getPassword());
        /*UserLoginVo userLoginVo = new UserLoginVo();
        BeanUtils.copyProperties(userLoginDto,userLoginVo);*/
        return userLoginDto;
    }

}
