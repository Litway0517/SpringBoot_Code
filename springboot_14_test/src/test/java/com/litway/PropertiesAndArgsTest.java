package com.litway;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


// SpringBoot的properties参数能够指定当前测试环境的参数, 而不是使用开发环境的配置文件作为配置
@SpringBootTest(properties = {"test.prop=testValue1"})
public class PropertiesAndArgsTest {

    @Value("${test.prop}")
    private String value;

    @Test
    void testProperties() {
        System.out.println(value);

        int[] array = new int[]{};
        array[0] = 1;
        System.out.println(array[0]);

    }
}
