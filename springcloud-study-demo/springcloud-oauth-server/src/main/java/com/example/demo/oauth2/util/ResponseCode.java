package com.example.demo.oauth2.util;

public enum  ResponseCode {
    SUCCESS(200){
        public Integer getCode(){
            return this.getCode();
        }
    },
    ERROR(0){
       public Integer getCode(){
           return this.getCode();
       }
    };
    private Integer code;

    ResponseCode(int code) {
       this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
