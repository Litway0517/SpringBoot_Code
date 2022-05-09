package com.litway;


import com.litway.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest

/*
    Import注解用来导入相关的 配置信息. 不仅导入了原始的配置信息, 即main路径下的配置, 而且还有MsgConfig配置
    这个Import注解仅仅是临时的配置, 不会影响其他环境. 因此能够作临时测试使用.
    场景: 临时想添加其他的第三方的配置信息, 就可以通过Import的方式
 */
@Import({MsgConfig.class})
public class ConfigurationTest {

    // 成员变量的名字 和 配置类中的方法的名称要一样
    @Autowired
    private String msg1;

    @Test
    void test() {
        System.out.println(msg1);
    }


}
