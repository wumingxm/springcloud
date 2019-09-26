package com.alibaba.nacos.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @Column(name = "studentNo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentNo;

    @Column(name = "studentName")
    private String  studentName;

    @Column(name = "studentAge")
    private  Integer studentAge;

    @Column(name = "studentSex")
    private  String  studentSex;

}
