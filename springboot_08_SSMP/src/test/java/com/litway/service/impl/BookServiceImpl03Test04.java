package com.litway.service.impl;

import com.litway.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceImpl03Test04 {

    @Autowired
    private BookServiceImpl03 bookService;

    @Test
    void save() {
        Book book = new Book();
        book.setType("test01");
        book.setName("测试");
        book.setDescription("测试用例");
        System.out.println(bookService.save(book));
    }

    @Test
    void update() {
        Book book = new Book();
        book.setId(13);
        book.setType("test01");
        book.setName("测试");
        book.setDescription("测试用例abc");
        System.out.println(bookService.update(book));
    }

    @Test
    void delete() {
        System.out.println(bookService.delete(16));
    }

    @Test
    void getById() {
        System.out.println(bookService.getById(10));
    }

    @Test
    void getAll() {
    }
}
