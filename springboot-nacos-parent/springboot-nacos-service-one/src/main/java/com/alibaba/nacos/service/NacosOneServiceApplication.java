package com.alibaba.nacos.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NacosOneServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosOneServiceApplication.class,args);
    }
}
