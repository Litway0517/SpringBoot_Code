package com.litway;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


// SpringBoot的properties参数能够 为当前测试环境添加临时配置属性, 而不是使用开发环境的配置文件作为配置
// @SpringBootTest(properties = {"test.prop=testValue1"})

/**
 * 属性和参数测试
 */

// SpringBoot的args参数也能够 为当前测试环境添加临时属性, 只不过有一点不一样
@SpringBootTest(args = {"--test.prop=8081"})

// properties参数和args参数均存在的时候, 此时args生效, 因为spring官网上说了args是命令行启动, 优先级更高
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String value;

    @Test
    void testProperties() {
        System.out.println(value);

        int[] array = new int[]{0, 1};
        array[0] = 1;
        System.out.println(array[0]);

    }
}
