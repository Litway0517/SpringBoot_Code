package com.litway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
// 标注此类归Spring容器管理
@Component

// 加载该类时同时将配置文件中的配置赋值到该类中, 前缀是具体配置的上一层, 多层的话就按照下面这样写
@ConfigurationProperties(prefix = "servers.a.b.c")
public class ServerConfig {

    private String ipAddress;
    private int port;
    private long timeout;

}
