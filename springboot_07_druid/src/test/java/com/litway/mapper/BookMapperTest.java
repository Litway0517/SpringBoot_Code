package com.litway.mapper;

import com.litway.Springboot07DruidApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Springboot07DruidApplication.class)
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testDruid() {
        System.out.println(bookMapper.getBookById(1));
    }

}
