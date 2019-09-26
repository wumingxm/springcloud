package com.alibaba.nacos.api.vo;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentVo {

    private Integer studentNo;

    private String  studentName;

    private  Integer studentAge;

    private  String  studentSex;
}
