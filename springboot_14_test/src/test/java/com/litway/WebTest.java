package com.litway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// webEnvironment参数的可选值为: RANDOM_PORT(随机生成端口) | DEFINE_PORT(使用配置文件的) | MOCK | NONE(无端口)
// SpringBootTest的参数webEnvironment作用是用来启动web环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// AutoConfigureMockMvc开启虚拟的MVC调用
@AutoConfigureMockMvc
public class WebTest {

    // 自动装配的方式注入mockMvc对象
    @Autowired
    MockMvc mockMvc;

    @Test
    void test() {

    }

    @Test
    void testWeb1() {
        System.out.println(mockMvc);
    }

    @Test
    void testWeb2(@Autowired MockMvc mvc) throws Exception {
        // 创建一个虚拟请求 -> http:ip:port/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行请求
        mvc.perform(builder);
    }



}
