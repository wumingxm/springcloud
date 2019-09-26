package com.alibaba.nacos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.retry.annotation.EnableRetry;

@MapperScan(basePackages = {"com.alibaba.nacos.api.dao"})
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@EnableRetry
@RefreshScope
@EnableBinding(Sink.class)
@SpringBootApplication
public class SpringBootStaterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStaterApplication.class, args);
    }

}
