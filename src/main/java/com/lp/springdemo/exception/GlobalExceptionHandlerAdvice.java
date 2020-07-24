package com.lp.springdemo.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    // 处理IllegalStateException类型的异常  (aop切面中抛出的异常类型)
    @ExceptionHandler(IllegalStateException.class)
    public BaseResult handleIllegalAccessException(IllegalStateException e) {
        if (e.getCause() instanceof OperationException ){
            OperationException operationException = (OperationException) e.getCause();
            return BaseResult.isFailure(operationException.getMessage());
        }
        return BaseResult.isFailure("系统错误，请联系管理员");
    }

    // 处理IllegalArgumentException类型的异常 (Guava的校验抛出的异常类型)
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResult handleIllegalArgumentException(IllegalArgumentException e) {
        return BaseResult.isFailure(e.getMessage());
    }

    // 处理Throwable类型的异常 (未处理的系统类型异常)
    @ExceptionHandler(Throwable.class)
    public BaseResult handleThrowable(Throwable e) {
        return BaseResult.isFailure("系统错误，请联系管理员");
    }

    // 处理MethodArgumentNotValidException类型的异常 (@Validated注解抛出异常)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return BaseResult.isFailure(errorMessage);
    }

}
