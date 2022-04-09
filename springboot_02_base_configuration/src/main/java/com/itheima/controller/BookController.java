package com.itheima.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/book")
public class BookController {

    @GetMapping("/list")
    public String list() {
        System.out.println("获取图书列表...");
        return "{'data':'获取图书列表...'}";
    }


}
