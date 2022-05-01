package com.litway.controller.utils;

import lombok.Data;

/*
    表现层一致类
 */
// lombok会是加载速度变慢 因为是使用的反射+注解
@Data
public class Result {
    // 传给前端的此次请求的成功或失败标识
    private boolean flag;
    // 封装的数据
    private Object data;

    // 异常消息
    private String msg;

    public Result() {}

    public Result(boolean flag) {
        this.flag = flag;
    }

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(String msg) {
        this.flag = false;
        this.msg = msg;
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
