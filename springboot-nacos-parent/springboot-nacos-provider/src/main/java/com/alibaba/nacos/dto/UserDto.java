package com.alibaba.nacos.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private Integer roleId;

    private String  authority;

}
