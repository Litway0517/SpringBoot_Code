package com.ithiema.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BookController {

    @GetMapping
    public String list() {
        System.out.println("springboot is running...");
        return "springboot is running...";
    }
}
