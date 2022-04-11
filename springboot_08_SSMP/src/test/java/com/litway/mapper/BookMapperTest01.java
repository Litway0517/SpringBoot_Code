package com.litway.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.SSMPApplication;
import com.litway.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;


@SpringBootTest(classes = SSMPApplication.class)
class BookMapperTest01 {

    @Autowired
    private BookMapper bookMapper;

    @Test
    void testSelect01() {
        System.out.println(bookMapper.selectById(1L));
    }

    @Test
    void testPage02() {
        // 获取第二页数据, 每页数据3条
        Page<Book> page = new Page<Book>(2, 3);
        Page<Book> bookPage = bookMapper.selectPage(page, null);
        bookPage.getRecords().forEach(System.out::println);
    }

    @Test
    void testSelectByCondition03() {
        String column = "spring";
        LambdaQueryWrapper<Book> lambdaQuery = new LambdaQueryWrapper<Book>();
        lambdaQuery.like(StringUtils.isNotBlank(column), Book::getName, column);
        List<Book> books = bookMapper.selectList(lambdaQuery);
        System.out.println(books);
    }
}

