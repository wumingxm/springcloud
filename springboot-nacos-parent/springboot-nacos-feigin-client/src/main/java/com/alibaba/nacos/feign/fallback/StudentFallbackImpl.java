package com.alibaba.nacos.feign.fallback;

import com.alibaba.nacos.api.domain.Student;
import com.alibaba.nacos.api.vo.PageVo;
import com.alibaba.nacos.api.vo.StudentVo;
import com.alibaba.nacos.feign.client.StudentServiceFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentFallbackImpl  implements FallbackFactory<StudentServiceFeign> {
    private Logger logger = LoggerFactory.getLogger(StudentFallbackImpl.class);
    @Override
    public StudentServiceFeign create(Throwable cause) {
       return  new StudentServiceFeign() {
           @Override
           public void saveStudent(StudentVo studentVo) {
                logger.info("saveStudent(Student student)");
           }

           @Override
           public void updateStudent(StudentVo studentVo) {
                log.error(" updateStudent(StudentVo studentVo)");
           }

           @Override
           public void deleteStudentById(Integer studentNo) {
                log.error("deleteStudentById(Integer studentNo)");
           }

           @Override
           public Page<StudentVo> findStudentPage(StudentVo studentVo, PageVo pageVo) {
               log.error("Page<StudentVo> findStudentPage(StudentVo studentVo, PageVo pageVo)");
               return null;
           }

           @Override
           public Student findStudentByStudentNo(Integer studentNo) {
               log.error("Student findStudentByStudentNo(Integer studentNo)");
               return null;
           }
       };
    }
}
