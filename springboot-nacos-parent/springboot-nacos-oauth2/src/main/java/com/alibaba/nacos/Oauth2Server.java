package com.alibaba.nacos;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import javax.persistence.EntityManager;

@EnableEurekaClient
@EnableResourceServer
@EnableHystrix
@EnableFeignClients
@MapperScan(basePackages = {"com.alibaba.nacos.api.dao"})
@SpringBootApplication(scanBasePackages={"com.alibaba.nacos.*"})
public class Oauth2Server {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2Server.class,args);
    }

    @Bean
    public JPAQueryFactory jpaQueryFactory (EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
