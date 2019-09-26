package com.nacos.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NacosConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient.class,args);
    }
}
