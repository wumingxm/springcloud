package com.alibaba.nacos.api.util;

import java.io.Serializable;

public class MessageResult implements Serializable {

    private  Integer code;

    private  String  message;

    private  Object  data;

    private  static MessageResult  messageResult = new MessageResult();

    public static MessageResult success(){
        return  messageResult;
    }

    public static MessageResult data(Object data){
        messageResult.data = data;
        return messageResult;
    }

    public static MessageResult message(String message){
        messageResult.message = message;
        return messageResult;
    }

    public static String getMessage(){
        return  messageResult.message;
    }

    public static Integer getCode(){
        return messageResult.code;
    }

    public static Object getData(){
        return messageResult.data;
    }

}
