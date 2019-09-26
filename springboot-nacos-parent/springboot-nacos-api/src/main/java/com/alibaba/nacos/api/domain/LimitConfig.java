package com.alibaba.nacos.api.domain;

import lombok.Data;

import java.util.Map;

@Data
public class LimitConfig {

    private String routeId;

    private Map tokenConfig;
}
