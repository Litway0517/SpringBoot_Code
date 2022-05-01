package com.litway.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.controller.utils.Result;
import com.litway.entity.Book;
import com.litway.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/*
    关闭正在占用端口的称需
        - 查询端口: netstat -ano
        - 查询指定端口: netstat -ano | findstr "端口号"
        - 根据PID进程号查询进程名称: tasklist | findstr "进程PID号"
        - 根据PID结束任务: taskkill -f -pid "进程PID号"

    结论: 使用下面两条就行了
        - 查询指定端口: netstat -ano | findstr "端口号"
        - 根据PID结束任务: taskkill -f -pid "进程PID号"
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public Result list() throws IOException {
        return new Result(true, bookService.list());
    }

    @PostMapping
    public Result save(@RequestBody Book book) throws IOException {
        // 通过异步请求的请求体JSON串提交过来
        if (book.getName().equals("123")) {
            throw new IOException();
        }
        boolean flag = bookService.save(book);
        return new Result(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    // 和视频不一样
    @PutMapping
    public Result update(@RequestBody Book book) {
        return new Result(bookService.updateById(book));
    }

    // 和视频不一样
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        return new Result(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public Result getBookById(@PathVariable("id") Integer id) {
        return new Result(true, bookService.getById(id));
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result page(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize, Book book) {
        Page<Book> page = bookService.getPage(currentPage, pageSize, book);
        // 如果请求的页码值大于了最大页码, 那么就返回最后一页
        if (currentPage > page.getPages()) {
            // 这里面别忘了覆盖数据
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new Result(true, page);
    }


}
