package com.lp.springdemo.exception;

public class OperationException extends Throwable {

    private String code;
    private String message;

    public OperationException(String message,String code) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
