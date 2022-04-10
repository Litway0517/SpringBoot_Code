package com;

import com.itheima.Springboot04JunitApplication;
import com.itheima.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

// 当引导类和本例的测试类所在的包名不一样的时候, 需要用classes参数手动指定出来
@SpringBootTest(classes = Springboot04JunitApplication.class)

// @ContextConfiguration和@SpringBootTest一样的
// @ContextConfiguration(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testDao() {
        bookDao.save();
    }

    @Test
    void contextLoads() {
        System.out.println("test....");
    }


}
