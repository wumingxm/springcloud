package com.alibaba.nacos.api.api;

import com.alibaba.nacos.api.domain.Student;
import com.alibaba.nacos.api.vo.PageVo;
import com.alibaba.nacos.api.vo.StudentVo;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;


public interface StudentApi {

        @PostMapping(value = "saveStudent",produces = {"application/json"})
        void saveStudent(@RequestBody StudentVo student);

        @PostMapping(value = "updateStudent",produces = {"application/json"})
        void updateStudent(@RequestBody StudentVo student);

        @PostMapping(value = "deleteStudentById/studentNo",produces = {"application/json"})
        void deleteStudentById(@PathVariable("studentNo") Integer studentNo);


        @PostMapping(value = "findStudentPage/{page}/{size}",produces = {"application/json"})
        Page<StudentVo> findStudentPage(@RequestBody StudentVo student, @PathParam("") PageVo pageVo);

        @PostMapping(value = "findStudentByStudentNo",produces = {"application/json"})
        Student findStudentByStudentNo(Integer studentNo);

}
