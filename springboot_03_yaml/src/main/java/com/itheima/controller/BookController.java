package com.itheima.controller;

import com.itheima.entity.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book")
public class BookController {

    /*
        使用一个实体类将YML中的数据加载进来 -> 常用方式
        这个MyDataSource的注入权仍然在开发人员手中, 并不是一旦创建MyDataSource后就直接自动注入.
            @ConfigurationProperties仅仅是标明 如果注入的话注入哪一段配置? 这个问题, 并不会进行注入这个动作
     */
    @Autowired
    private MyDataSource dataSource;

    @GetMapping("/list")
    public String list() {
        System.out.println("--------------------------------");
        System.out.println("加载YML中的某一段配置 =======> " + dataSource);
        return "{'data':'获取图书列表...'}";
    }


}
