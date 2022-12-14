package com.itheima.controller;


import com.itheima.entity.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
        System.out.println("--------------------------------");
        System.out.println("所有配置数据environment ====> " + environment);
        System.out.println("取出来某个environment中的数据 ====> " + environment.getProperty("users[0].name"));
        System.out.println("--------------------------------");
        System.out.println("加载YML中的某一段配置 =======> " + dataSource);
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

    // 使用自动装配将所有的配置数据封装到一个对象中. 避免定义了上千个变量来接收配置中的数据
    @Autowired
    private Environment environment;

    /*
        使用一个实体类将YML中的数据加载进来 -> 常用方式
        这个MyDataSource的注入权仍然在开发人员手中, 并不是一旦创建MyDataSource后就直接自动注入.
            @ConfigurationProperties仅仅是标明 如果注入的话注入哪一段配置? 这个问题, 并不会进行注入这个动作
     */
    @Autowired
    private MyDataSource dataSource;

}
