package com.alibaba.nacos.api.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response  implements Serializable {

    private String code;

    private String message;

    private String data;
}
