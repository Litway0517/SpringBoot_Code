package com.litway.controller.utils;

import lombok.Data;

@Data
public class R08 {
    // 传给前端的此次请求的成功或失败标识
    private boolean flag;
    // 封装的数据
    private Object data;

    public R08() {}

    public R08(boolean flag) {
        this.flag = flag;
    }

    public R08(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
