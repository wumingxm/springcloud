package com.alibaba.nacos.api.dao;

import com.alibaba.nacos.api.domain.Student;

import javax.inject.Named;

@Named
public interface  StudentDao extends  BaseDao<Student,Integer> {
}
