package com.alibaba.nacos.api.api;

import com.alibaba.nacos.api.pojo.JWT;
import com.alibaba.nacos.api.vo.UserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


public interface UserApi {

    @PostMapping("oauth/token")
    JWT getToken(@RequestHeader(value="Authorization")String authorization, @RequestParam("grant_type") String grant_type,@RequestParam("username") String username,@RequestParam("password") String password);

    @PostMapping(value = "findUserByUserName")
    UserVo findUserByUserName(String username);
}
