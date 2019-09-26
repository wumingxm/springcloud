package com.alibaba.nacos.api.dao;

import com.alibaba.nacos.api.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherDao {

    @Select(value = {"select tno,tname from teacher  where tno=#{tno,jdbcType=NUMERIC}"})
    public Teacher findTeacherByTno(@Param("tno")Integer tno);
}
