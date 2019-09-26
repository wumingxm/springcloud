package com.alibaba.nacos.api.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = -2021973090L;

    public static final QStudent student = new QStudent("student");

    public final NumberPath<Integer> studentAge = createNumber("studentAge", Integer.class);

    public final StringPath studentName = createString("studentName");

    public final NumberPath<Integer> studentNo = createNumber("studentNo", Integer.class);

    public final StringPath studentSex = createString("studentSex");

    public QStudent(String variable) {
        super(Student.class, forVariable(variable));
    }

    public QStudent(Path<? extends Student> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudent(PathMetadata metadata) {
        super(Student.class, metadata);
    }

}

