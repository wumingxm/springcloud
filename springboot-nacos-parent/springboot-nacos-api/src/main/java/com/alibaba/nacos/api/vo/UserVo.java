package com.alibaba.nacos.api.vo;

import lombok.Data;

@Data
public class UserVo {

    private Long id;

    private String username;

    private String password;

    private Integer roleId;

    private String  authority;
}
