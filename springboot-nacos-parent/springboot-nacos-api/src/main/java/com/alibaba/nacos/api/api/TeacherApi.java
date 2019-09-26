package com.alibaba.nacos.api.api;

import com.alibaba.nacos.api.domain.Teacher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface TeacherApi {

    @RequestMapping("/findTeacherByTno/{tno}")
    public Teacher findTeacherByTno(@PathVariable("tno")Integer tno);
}
