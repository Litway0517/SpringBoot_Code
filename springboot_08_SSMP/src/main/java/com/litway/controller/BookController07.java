package com.litway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.entity.Book;
import com.litway.service.IBookService05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 注释掉, 不加载这个Bean了
// @RestController
@RequestMapping("/books")
public class BookController07 {

    @Autowired
    private IBookService05 bookService;

    @GetMapping("/list")
    public List<Book> list() {
        return bookService.list();
    }

    @PostMapping
    public boolean save(@RequestBody Book book) {
        // 通过异步请求的请求体JSON串提交过来
        return bookService.save(book);
    }

    // 和视频不一样
    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.updateById(book);
    }

    // 和视频不一样
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return bookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Page<Book> page(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize) {
        return bookService.getPage(currentPage, pageSize);
    }



}
