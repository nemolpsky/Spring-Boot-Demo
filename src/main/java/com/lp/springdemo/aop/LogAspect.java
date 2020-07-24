package com.lp.springdemo.aop;

import com.google.common.base.Stopwatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Order(1)
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private static StringBuilder builder = new StringBuilder(200);

    // 定义一个切入点
    @Pointcut("execution(* com.lp.springdemo.controller.*.*(..))")
    public void pointCutController() {
    }

    // 环绕通知
    @Around("pointCutController()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 获取请求方法名
        String name = builder.append(pjp.getSignature().getDeclaringTypeName())
                .append(".").append(pjp.getSignature().getName()).toString();
        // 获取请求参数
        String param = Arrays.toString(pjp.getArgs());
        // 统计方法执行时间
        Stopwatch stopwatch = Stopwatch.createStarted();
        // 获取执行的返回结果
        Object result = null;
        String resultMessage = "";

        // 方法是否执行成功
        boolean isSuccess = true;
        String errorMessage = "";

        long millis = 0L;
        try {
            result = pjp.proceed();
            if (result!=null) {
                resultMessage = result.toString();
            }
            millis = stopwatch.stop().elapsed(TimeUnit.MILLISECONDS);
        } catch (Throwable throwable) {
            // 修改标记，并且读取异常堆栈信息
            isSuccess = false;
            errorMessage = getStackInfo(throwable);
            throw throwable;
        } finally {
            logger.info("LogAspect-[{}]方法，执行结果：[{}]，请求参数：{}，返回参数：[{}]，执行时间：[{}]毫秒，异常信息：[{}]", name, isSuccess, param, resultMessage, millis, errorMessage);
            builder.delete(0, builder.length() - 1);
        }
        return result;
    }

    /**
     * 打印堆栈信息
     * @param e 异常
     * @return 异常堆栈信息
     */
    public static String getStackInfo(Throwable e) {

        String msg = "empty stack info ...";
        try (
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                PrintWriter writer = new PrintWriter(buf, true)
        ) {
            e.printStackTrace(writer);
            msg = buf.toString();
        }catch (Exception exception){
            logger.error("LogAspect-getStackInfo：",exception);
        }
        return msg;
    }
}
