package com.litway.controller;


import com.litway.controller.utils.R08;
import com.litway.entity.Book;
import com.litway.service.IBookService05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController09 {

    @Autowired
    private IBookService05 bookService;

    @GetMapping("/list")
    public R08 list() {
        return new R08(true, bookService.list());
    }

    @PostMapping
    public R08 save(@RequestBody Book book) {
        // 通过异步请求的请求体JSON串提交过来
        return new R08(bookService.save(book));
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
    public R08 page(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize) {
        return new R08(true, bookService.getPage(currentPage, pageSize));
    }



}
