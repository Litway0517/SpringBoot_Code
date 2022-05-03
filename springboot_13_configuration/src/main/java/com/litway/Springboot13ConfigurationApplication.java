package com.litway;

import com.alibaba.druid.pool.DruidDataSource;
import com.litway.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

// 该注解用来开启配置属性注入, 说明了需要将配置属性中某些属性赋值给ServerConfig类. 因此此时会向Spring容器中注入一次ServerConfig.
// 所以不能个@Component一块使用
@EnableConfigurationProperties({ServerConfig.class})
public class Springboot13ConfigurationApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DruidDataSource dataSource() {
		// 德鲁伊的数据加载是懒加载
		DruidDataSource ds = new DruidDataSource();
		// ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return ds;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
		ServerConfig bean = run.getBean(ServerConfig.class);
		System.out.println(bean);
		DruidDataSource ds = run.getBean(DruidDataSource.class);
		System.out.println(ds);
		System.out.println(ds.getDriverClassName());

	}

}
