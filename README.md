# Spring-Boot-Demo
基于Spring Boot搭建、测试一些提高开发效率的模式和类库


### AOP
- 日志打印Controller层的请求输入、输出、执行时间以及异常情况，com.lp.springdemo.aop.LogAspect

---

### 异常
- 处理Controller层的全局异常器，com.lp.springdemo.exception.GlobalExceptionHandlerAdvice

---

### Controller层
- 测试各种类型异常的全局捕获，com.lp.springdemo.controller.TestController