package com.example.demo.oauth2.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.oauth2.service.BaseUserDetialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Configuration
public class CustomAuthenticationProvider  extends DaoAuthenticationProvider {

    @Autowired
    private BaseUserDetialService baseUserDetialService;

    @Autowired
    public CustomAuthenticationProvider(BaseUserDetialService baseUserDetialService){
        this.setUserDetailsService(baseUserDetialService);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username = authentication.getName();
       String password = (String)authentication.getCredentials();
       UserDetails baseUser  = this.baseUserDetialService.loadUserByUsername(username);
       Collection<? extends GrantedAuthority> authorities  =  baseUser.getAuthorities();
       Authentication authentication1Token =  new UsernamePasswordAuthenticationToken(JSON.toJSONString(authorities, SerializerFeature.NotWriteDefaultValue),password,authorities);
        return authentication1Token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
