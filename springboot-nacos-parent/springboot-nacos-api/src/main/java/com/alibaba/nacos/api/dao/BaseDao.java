package com.alibaba.nacos.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseDao<T,P extends Serializable>  extends JpaRepository<T,P>, CrudRepository<T,P>, JpaSpecificationExecutor<T>, PagingAndSortingRepository<T,P>, QueryDslPredicateExecutor<T>{
}
