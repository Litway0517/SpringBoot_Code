package com.litway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
// 标注此类归Spring容器管理, 不和@EnableConfigurationProperties一块使用
//@Component

// 加载该类时同时将配置文件中的配置赋值到该类中, 前缀是具体配置的上一层, 多层的话就按照下面这样写
@ConfigurationProperties(prefix = "servers.a.b.c")
public class ServerConfig {

    private String ipAddress;
    private int port;
    private long timeout;

    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;

}
