package com.alibaba.nacos.service;

import com.alibaba.nacos.api.dao.TeacherDao;
import com.alibaba.nacos.api.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Teacher findTeacherByTno(Integer tno){
        return teacherDao.findTeacherByTno(tno);
    }

}
