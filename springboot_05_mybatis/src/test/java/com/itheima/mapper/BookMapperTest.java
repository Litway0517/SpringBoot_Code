package com.itheima.mapper;

import com.itheima.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {

    // 验证一下Autowired和Qualifier两个注解搭配使用. 当容器中有两个一样类型的Bean时不能够自动装配. 需要搭配Qualifier注解指定
    @Autowired
    @Qualifier("bookMapper1")
    private BookMapper bookMapper;

    @Test
    void getBookById() {
        Book bookById = bookMapper.getBookById(1);
        System.out.println("图书信息 ==========> " + bookById);

    }
}
