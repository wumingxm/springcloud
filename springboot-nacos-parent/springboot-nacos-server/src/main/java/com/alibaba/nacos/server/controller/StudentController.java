package com.alibaba.nacos.server.controller;

import com.alibaba.nacos.api.api.StudentApi;
import com.alibaba.nacos.api.domain.Student;
import com.alibaba.nacos.api.vo.PageVo;
import com.alibaba.nacos.api.vo.StudentVo;
import com.alibaba.nacos.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class StudentController  implements StudentApi {

    @Autowired
    private StudentService studentService;

    @Override
    public void saveStudent(@RequestBody StudentVo studentVo) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVo,student);
        studentService.saveStudent(student);
    }

    @Override
    public void updateStudent(@RequestBody StudentVo studentVo){
        Student student = new Student();
        BeanUtils.copyProperties(studentVo,student);
        studentService.saveStudent(student);
    }

    @Override
    public void deleteStudentById(@PathVariable("studentNo") Integer studentNo){
        studentService.deleteStudentById(studentNo);
    }


    @Override
    public Page<StudentVo> findStudentPage(@RequestBody StudentVo studentVo, @PathParam("") PageVo pageVo){
        Student student = new Student();
        BeanUtils.copyProperties(studentVo,student);
        return  studentService.findStudentPage(student,pageVo);
    }

    @Override
    public Student findStudentByStudentNo(Integer studentNo){
        return studentService.findStudentByStudentNo(studentNo);
    }
}
