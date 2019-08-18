package com.example.demo.oauth2.jpa.dao;

import com.example.demo.oauth2.domain.BaseRole;
import org.springframework.data.repository.CrudRepository;

public interface BaseRoleDao   extends CrudRepository<BaseRole,Integer> {

    public BaseRole findByUserId(Integer userId);

}
