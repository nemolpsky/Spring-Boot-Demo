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


---

### Util
- BeanUtil，com.lp.springdemo.utils.BeanUtil
  - 对象属性复制
  - 值初始化
- JsonUtil，com.lp.springdemo.utils.JsonUtil
  - JSON与map，Object之间的转换
  - 创建JSON，提供连缀使用语法，com.lp.springdemo.utils.JsonBuilder
---

### Test类
- 测试BeanUtil，com.lp.springdemo.BeanUtilTest
- 测试JsonUtil，com.lp.springdemo.JacksonTest