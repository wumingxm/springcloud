package com.example.demo.oauth2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table
public class BaseRole implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "authority")
    private String authority;

    @Column(name = "roleCode")
    private String roleCode;

    @Override
    public String getAuthority() {
        return null;
    }
}
