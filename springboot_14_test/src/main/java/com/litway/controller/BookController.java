package com.litway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public String getBookById() {
        System.out.println("getBook is running...");
        return "springboot";
    }

}
