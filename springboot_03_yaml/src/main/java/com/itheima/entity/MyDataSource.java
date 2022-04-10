package com.itheima.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
    以后开发中常用的方式
    1- 创建相应的实体类, 用来接收YML中的某一段配置文件
    2- 使用Component注解, 将这个实体类加载到Spring容器中, 这样才能够归IOC进行管理
    3- 使用Configuration注解, 标明具体是哪一段配置注入给此实体类对象
 */

@Data
@Component
@ConfigurationProperties(prefix = "datasource")
public class MyDataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

}
