package com.litway;

import com.litway.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot13ConfigurationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
		ServerConfig bean = run.getBean(ServerConfig.class);
		System.out.println(bean);

	}

}
