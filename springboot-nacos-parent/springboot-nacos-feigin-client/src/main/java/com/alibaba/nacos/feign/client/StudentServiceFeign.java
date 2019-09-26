package com.alibaba.nacos.feign.client;

import com.alibaba.nacos.api.api.StudentApi;
import com.alibaba.nacos.feign.fallback.StudentFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "student",fallbackFactory = StudentFallbackImpl.class)
public interface StudentServiceFeign extends StudentApi {

}
