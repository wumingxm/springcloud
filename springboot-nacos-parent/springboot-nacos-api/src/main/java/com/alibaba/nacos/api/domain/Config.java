package com.alibaba.nacos.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {

    private Integer burstCapacity;

    private Integer replenishRate;
}
