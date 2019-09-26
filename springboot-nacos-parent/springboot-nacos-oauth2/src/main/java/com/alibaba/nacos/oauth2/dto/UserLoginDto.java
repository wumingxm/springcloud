package com.alibaba.nacos.dto;

import com.alibaba.nacos.api.domain.User;
import com.alibaba.nacos.api.pojo.JWT;
import lombok.Data;

@Data
public class UserLoginDto {

    private User user;

    private JWT  jwt;
}
