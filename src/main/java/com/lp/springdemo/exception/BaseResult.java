package com.lp.springdemo.exception;

public class BaseResult {

    private final static String SUCCESS_CODE = "00-0000";
    private final static String SUCCESS_MSG = "success";
    private final static String FAILURE_CODE = "00-0001";

    private String code;
    private String message;
    private Object data;

    public BaseResult(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static BaseResult isSuccess(Object object){
        return new BaseResult(SUCCESS_CODE,SUCCESS_MSG,object);
    }

    public static BaseResult isFailure(String message){
        return new BaseResult(FAILURE_CODE,message,null);
    }
}
