package com.litway.controller;


import com.litway.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 图书控制器
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getBookById() {

        Book book = new Book();
        book.setId(10);
        book.setName("从入门到删库跑路");
        book.setDescription("测试");
        book.setType("SpringCloud");

//        return book;
        return "springboot...";
    }

}
