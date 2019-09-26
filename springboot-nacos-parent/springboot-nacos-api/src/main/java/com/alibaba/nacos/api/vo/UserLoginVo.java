package com.alibaba.nacos.api.vo;

import com.alibaba.nacos.api.domain.User;
import com.alibaba.nacos.api.pojo.JWT;
import lombok.Data;

@Data
public class UserLoginVo {
    private User user;

    private JWT jwt;
}
