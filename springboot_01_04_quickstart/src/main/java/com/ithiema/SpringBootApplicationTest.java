package com.ithiema;


import com.ithiema.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// SpringBoot注解默认扫描的是com.itheima包下面的所有的相关的驱动注解, 例如@Component @Service等
@SpringBootApplication
public class SpringBootApplicationTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootApplicationTest.class);
        BookController bean = ctx.getBean(BookController.class);
        // Bean的信息 ===========> com.ithiema.controller.BookController@267bbe1a
        System.out.println("Bean的信息 ===========> " + bean);
    }

}
