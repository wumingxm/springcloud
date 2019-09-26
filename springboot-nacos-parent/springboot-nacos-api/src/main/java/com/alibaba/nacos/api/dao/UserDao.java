package com.alibaba.nacos.api.dao;

import com.alibaba.nacos.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User,Long>, CrudRepository<User,Long> {
    @Query(nativeQuery = true, value ="select u.uid , u.username ,u.password,u.role_id,u.authority  from user u where  u.username = :username" )
    User findByUsername(@Param("username") String username);
}
