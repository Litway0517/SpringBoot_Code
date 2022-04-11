package com.litway.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.SSMPApplication;
import com.litway.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = SSMPApplication.class)
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelect() {
        System.out.println(bookMapper.selectById(1L));
    }

    @Test
    void testPage() {
        // 获取第二页数据, 每页数据3条
        Page<Book> page = new Page<Book>(2, 3);
        Page<Book> bookPage = bookMapper.selectPage(page, null);
        bookPage.getRecords().forEach(System.out::println);
    }

}
