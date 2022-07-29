package com.litway;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试
 *
 * @author DELL_
 * @date 2022/07/22
 */
@SpringBootTest
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        String s = "图文编号 " + "254345345" + " 已经存在, 请重新操作. ";
        System.out.println(s.contains("254345345"));

    }


}
