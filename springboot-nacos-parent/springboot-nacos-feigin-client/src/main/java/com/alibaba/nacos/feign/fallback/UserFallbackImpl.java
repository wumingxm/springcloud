package com.alibaba.nacos.feign.fallback;

import com.alibaba.nacos.api.pojo.JWT;
import com.alibaba.nacos.api.vo.UserVo;
import com.alibaba.nacos.feign.client.UserServiceFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserFallbackImpl implements FallbackFactory<UserServiceFeign> {

    @Override
    public UserServiceFeign create(Throwable cause) {
        return  new UserServiceFeign() {
            @Override
            public JWT getToken(String authorization, String type, String username, String password) {
                log.error(" JWT getToken(String authorization, String type, String username, String password)");
                JWT jwt = new JWT();
                jwt.setJti(cause.getMessage());
                jwt.setAccess_token(cause.getLocalizedMessage());
                return jwt;
            }

            @Override
            public UserVo findUserByUserName(String username) {
                log.error("UserVo findUserByUserName(String username)");
                return null;
            }
        };
    }
}
