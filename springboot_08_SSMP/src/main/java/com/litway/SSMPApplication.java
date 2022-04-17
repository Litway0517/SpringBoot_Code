package com.litway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ssmpapplication
 *
 * @author DELL_
 * @date 2022/04/17
 */
/*
    windows部署, 首先需要打包, 但是如果打包过程包含test的话, 项目上线就会多出来很多数据,
    这是测试过程中产生的数据. 因此需要使用Toggle test进行打包, 然后去命令行启动java -jar name.jar
 */
@SpringBootApplication
public class SSMPApplication {

    public static void main(String[] args) {
        SpringApplication.run(SSMPApplication.class, args);
    }

}
