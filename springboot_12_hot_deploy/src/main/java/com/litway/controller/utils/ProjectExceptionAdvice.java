package com.litway.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @ControllerAdvice

// 标识此类为Controller的通知增强类
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有异常 @ExceptionHandler注解标识该方法用来处理异常
    @ExceptionHandler
    public Result doException(Exception ex) {
        // 记录日志 -> 查看哪个方法出现了错误
        // 通知开发 -> 出现了异常需要处理
        // 通知运维 -> 查看日志

        // 控制台打印一下异常 -> 不然报错了也不出来 怎么搞都看不到异常在哪里?
        ex.printStackTrace();
        return new Result( "出现异常, 请稍后重试~");
    }

}
