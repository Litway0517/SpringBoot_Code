package com.itheima.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class BookController {

    @GetMapping("/list")
    public String list() {
        System.out.println("获取图书列表...");
        return "获取图书列表...";
    }


}
