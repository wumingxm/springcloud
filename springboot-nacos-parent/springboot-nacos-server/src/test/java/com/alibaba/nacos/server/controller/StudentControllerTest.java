package com.alibaba.nacos.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public void deleteStudentById() throws  Exception{
        Map map = new HashMap();
        map.put("studentNo",1);
        this.mockMvc.perform(get("/")
                .param("studentNo","1")
                .header("Authentication","xxxxxxxxxxxxxxxxx")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(document("index",requestFields(new FieldDescriptor[]{
                        fieldWithPath("studentNo").description("学号"),
                        fieldWithPath("studentName").description("姓名"),
                        fieldWithPath("studentAge").description("年龄"),
                        fieldWithPath("studentSex").description("性别")
                })))
                .andDo(document("index",responseFields(new FieldDescriptor[]{
                        fieldWithPath("studentNo").description("学号"),
                        fieldWithPath("studentName").description("姓名"),
                        fieldWithPath("studentAge").description("年龄"),
                        fieldWithPath("studentSex").description("性别")
                })))
                .andReturn().getResponse().getContentAsString();
    }

}
