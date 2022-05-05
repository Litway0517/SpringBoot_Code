package com.litway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

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

    // @DurationUnit用来指定Duration类型的单位. 毫秒 秒 分 时 天 周 月 年等等. 默认单位为毫秒
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;

    // @DataSizeUnit注解用来标识DataSize类型的数据的单位. 如果直接在配置文件写上10MB也行, 但是不能使用注解. 如果使用的话以配置文件为准
    // 单位分为字节 KB MB GB TB. 默认为字节
    @DataSizeUnit(DataUnit.KILOBYTES)
    private DataSize dataSize;

}
