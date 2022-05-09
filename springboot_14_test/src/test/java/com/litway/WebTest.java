package com.litway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// webEnvironment参数的可选值为: RANDOM_PORT(随机生成端口) | DEFINE_PORT(使用配置文件的) | MOCK | NONE(无端口)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebTest {

    @Test
    void test() {

    }

}
