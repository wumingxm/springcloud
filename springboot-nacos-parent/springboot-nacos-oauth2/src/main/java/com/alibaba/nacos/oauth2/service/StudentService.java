package com.alibaba.nacos.service;

import com.alibaba.nacos.api.dao.StudentDao;
import com.alibaba.nacos.api.domain.QStudent;
import com.alibaba.nacos.api.domain.Student;
import com.alibaba.nacos.api.vo.PageVo;
import com.alibaba.nacos.api.vo.StudentVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 学生服务
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JPAQueryFactory factory;

    public void saveStudent(Student student){
        studentDao.save(student);
    }

    /**
     * 分页查询学生信息
     * @param student
     * @param pageVo
     * @return
     */
    public Page<Student> findStudent(Student student, PageVo pageVo){
        return  studentDao.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                return null;
            }
        },new PageRequest(pageVo.getPage(),pageVo.getSize()));
    }

    /**
     * 条件查询学生信息
     * @param student
     */
    public void findByStudent(final Student student){
        studentDao.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
               Expression expression = root.get("studentName");
               List<Predicate> predicates = new ArrayList<Predicate>();
               Predicate finalConditiion = cb.conjunction();
               if(root.get("studentName")!=null){
                  predicates.add(cb.and(cb.equal(root.get("studentName"),student.getStudentName())));
               }
               return query.where( predicates.toArray(new Predicate[]{})).getRestriction();
            }
        });
    }

    /**
     * 条件查询学生信息
     * @param studentNo
     */
    public void deleteStudentById(Integer studentNo){
        studentDao.delete(studentNo);
    }

    /**
     * 根据学号查询学生信息
     * @param studentNo
     * @return
     */
    public Student findStudentByStudentNo(Integer studentNo){
        return studentDao.findOne(studentNo);
    }

    /**
     * 分页条件查询
     * @param student
     * @param pageVo
     * @return
     */
    public Page<Student>findStudentPage2(Student student,PageVo pageVo){
       QStudent stu = QStudent.student;
       List<Student> results = factory.selectFrom(stu)
               .offset((pageVo.getPage()-1)*pageVo.getSize())
               .limit(pageVo.getSize()).fetch();
       Long total = factory.selectFrom(stu).fetchCount();
       return new PageImpl<Student>(results,new PageRequest(pageVo.getPage(),pageVo.getSize()),total);
    }

    public Page<StudentVo>findStudentPage(Student student, PageVo pageVo){
        QStudent stu  = QStudent.student;
        List<StudentVo> studentList = factory.select(stu.studentNo,stu.studentAge,stu.studentName,stu.studentSex)
                .from(stu)
                .offset((pageVo.getPage()-1)*pageVo.getSize())
                .limit(pageVo.getSize())
                .fetch().stream().map(
                        s-> StudentVo.builder()
                                .studentNo(s.get(0,Integer.class))
                                .studentAge(s.get(1,Integer.class))
                                .studentName(s.get(2,String.class)).build())
               .collect(Collectors.toList());
          Long total = factory.selectFrom(stu).fetchCount();
          Page <StudentVo> page = new PageImpl(studentList,new PageRequest(pageVo.getPage(),pageVo.getSize()),total);
          return page;
    }
}
