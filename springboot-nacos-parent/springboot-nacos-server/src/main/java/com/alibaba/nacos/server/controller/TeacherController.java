package com.alibaba.nacos.server.controller;

import com.alibaba.nacos.api.api.TeacherApi;
import com.alibaba.nacos.api.domain.Teacher;
import com.alibaba.nacos.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController implements TeacherApi {

    @Autowired
    private TeacherService teacherService;

    @Override
    public Teacher findTeacherByTno(@PathVariable("tno") Integer tno){
        return teacherService.findTeacherByTno(tno);
    }

}
