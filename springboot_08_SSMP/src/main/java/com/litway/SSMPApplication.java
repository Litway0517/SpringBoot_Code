package com.litway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

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
        // 这里的args就是启动时传入的参数, 这个参数和上面工具栏锤子右面的编辑菜单有联系. 就是填写的参数
        System.out.println(Arrays.toString(args));

        // 当然也能够手动传参
        String[] arg = new String[1];
        arg[0] = "--server.port=8082";
        SpringApplication.run(SSMPApplication.class, arg);
    }

}
