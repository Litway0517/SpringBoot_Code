package com.litway.mapper;

import com.litway.Springboot06MybatisPlusApplication;
import com.litway.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Springboot06MybatisPlusApplication.class)
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testDao() {
        Book book = bookMapper.selectById(1L);
        System.out.println("通过MyBatisPlus查询到的数据 =============> " + book);
    }

}
