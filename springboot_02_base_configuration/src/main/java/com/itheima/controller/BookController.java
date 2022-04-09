package com.itheima.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/book")
public class BookController {

    @GetMapping("/list")
    public String list() {
        System.out.println("获取图书列表...");
        System.out.println("country ====> " + country);
        System.out.println("username ====> " + username);
        System.out.println("age ====> " + age);
        System.out.println("dir ====> " + dir);
        System.out.println("dir2 ====> " + dir2);
        return "{'data':'获取图书列表...'}";
    }

    // 读取YML文件中的内容
    @Value("${country}")
    private String country;

    @Value("${users[1].name}")
    private String username;

    @Value("${users2[0].age}")
    private String age;

    @Value("${tempDir}")
    private String dir;

    @Value("${tempDir3}")
    private String dir2;

}
