package com.litway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息配置
 */

// Configuration注解用来告诉spring容器这是一个配置类
@Configuration
public class MsgConfig {

    // 这里面仅仅是作演示, 所以返回的值是String类型, 可以改成第三方
    @Bean
    public String msg1() {
        return "bean msg111";
    }

    @Bean
    public String msg2() {
        return "bean msg222";
    }


}
