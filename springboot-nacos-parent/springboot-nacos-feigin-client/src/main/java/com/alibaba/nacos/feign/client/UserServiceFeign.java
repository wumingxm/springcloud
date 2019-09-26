package com.alibaba.nacos.feign.client;

import com.alibaba.nacos.api.api.UserApi;
import com.alibaba.nacos.feign.fallback.UserFallbackImpl;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name ="us",fallbackFactory = UserFallbackImpl.class,url = "http://localhost:9999")
public interface UserServiceFeign  extends UserApi {

}
