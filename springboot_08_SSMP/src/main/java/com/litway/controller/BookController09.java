package com.litway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.controller.utils.R08;
import com.litway.entity.Book;
import com.litway.service.IBookService05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController09 {

    @Autowired
    private IBookService05 bookService;

    @GetMapping("/list")
    public R08 list() throws IOException {
        return new R08(true, bookService.list());
    }

    @PostMapping
    public R08 save(@RequestBody Book book) throws IOException {
        // 通过异步请求的请求体JSON串提交过来
        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new R08(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    // 和视频不一样
    @PutMapping
    public R08 update(@RequestBody Book book) {
        return new R08(bookService.updateById(book));
    }

    // 和视频不一样
    @DeleteMapping("/{id}")
    public R08 delete(@PathVariable("id") Integer id) {
        return new R08(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R08 getBookById(@PathVariable("id") Integer id) {
        return new R08(true, bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R08 page(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize, Book book) {
        Page<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果请求的页码值大于了最大页码, 那么就返回最后一页
        if (currentPage > page.getPages()) {
            // 这里面别忘了覆盖数据
            page = bookService.getPage((int)page.getPages(), pageSize, book);
        }
        return new R08(true, page);
    }



}
