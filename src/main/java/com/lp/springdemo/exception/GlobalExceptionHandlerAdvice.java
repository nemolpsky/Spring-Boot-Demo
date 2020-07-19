package com.lp.springdemo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    // 处理IllegalStateException类型的异常
    @ExceptionHandler(IllegalStateException.class)
    public BaseResult handleIllegalAccessException(IllegalStateException e) {
        if (e.getCause() instanceof OperationException ){
            OperationException operationException = (OperationException) e.getCause();
            return BaseResult.isFailure(operationException.getMessage());
        }
        return BaseResult.isFailure("系统错误，请联系管理员");
    }

    // 处理IllegalArgumentException类型的异常
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResult handleIllegalAccessException(IllegalArgumentException e) {
        return BaseResult.isFailure(e.getMessage());
    }

    // 处理Throwable类型的异常
    @ExceptionHandler(Throwable.class)
    public BaseResult handleThrowable(Throwable e) {
        return BaseResult.isFailure("系统错误，请联系管理员");
    }
}
