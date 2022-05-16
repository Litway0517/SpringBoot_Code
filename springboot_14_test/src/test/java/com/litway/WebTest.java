package com.litway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

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
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 发送请求, 会有一个返回值
        ResultActions perform = mvc.perform(builder);

        // 获取本次发送请求的响应体, 返回的是ContentResultMatchers对象
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // 设置本次请求的预计值
        ResultMatcher result = content.string("springboot");

        // 添加预计值到本次调用中, 进行匹配
        perform.andExpect(result);

    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        /*
            S1- 模拟请求
            S2- 发送请求
            S3- 接收请求并验证
         */
        // 创建一个虚拟请求 -> http:ip:port/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 发送请求, 会有一个返回值
        ResultActions perform = mvc.perform(builder);

        // 设定预期值 与 真实值进行比较, 成功则测试通过, 否则测试失败
        // 定义本次调用的预期值, 是一个叫做ResultMatcher的对象
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用是成功的, status为200
        ResultMatcher ok = status.isOk();

        // 添加预计值到本次调用中, 进行匹配
        perform.andExpect(ok);

    }



}
