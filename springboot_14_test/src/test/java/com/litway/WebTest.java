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
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * 表现层测试
 */

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

    // 真正使用这种方式进行测试时的例子
    @Test
    void testGetBookById(@Autowired MockMvc mockMvc) throws Exception {
        // 发送请求
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.get("/books");
        // 发送请求
        ResultActions perform = mockMvc.perform(mock);

        /*
            定义一个规则就匹配一个规则. 获取一个结果之后设置对应的预测值就测试
                1- 匹配请求状态是否成功
                2- 匹配返回的内容
                3- 匹配请求头
         */
        StatusResultMatchers status = MockMvcResultMatchers.status();
        ResultMatcher ok = status.isOk();
        perform.andExpect(ok);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher json = content.json("{\"id\":10,\"type\":\"SpringCloud\",\"name\":\"从入门到删库跑路\",\"description\":\"测试\"}");
        perform.andExpect(json);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher matcher = header.string("Content-Type", "application/json");
        perform.andExpect(matcher);

    }


    // 匹配响应头 -> 错误情况 请求时是text/plain;charset=UTF-8, 但是预测值为application/json
    @Test
    void testHeaders(@Autowired MockMvc mockMvc) throws Exception {
        // 发送请求
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.get("/books");

        // 发送请求
        ResultActions perform = mockMvc.perform(mock);

        // 获取测试结果
        HeaderResultMatchers header = MockMvcResultMatchers.header();

        // 设置预期值
        ResultMatcher matcher = header.string("Content-Type", "application/json");

        // 比较
        perform.andExpect(matcher);

    }


    // 返回JSON
    @Test
    void testJson(@Autowired MockMvc mockMvc) throws Exception {
        // 构造请求
        MockHttpServletRequestBuilder mock = MockMvcRequestBuilders.get("/books");

        // 发送请求
        ResultActions perform = mockMvc.perform(mock);

        // 获取本次测试的结果
        ContentResultMatchers content = MockMvcResultMatchers.content();

        // 设计本次请求得到的结果(主要是观察错误时的信息)
        ResultMatcher json = content.json("{\"id\":10,\"type\":\"SpringCloud\",\"name\":\"从入门到删库跑路\",\"description\":\"测试\"}");

        // 自动进行匹配测试
        perform.andExpect(json);

    }



    // 返回一个字符串
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
