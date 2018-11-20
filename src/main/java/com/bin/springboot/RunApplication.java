package com.bin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableCaching //开启缓存
@EnableDiscoveryClient //开启eureka客户端
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启Security权限验证
@EnableResourceServer
public class RunApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(RunApplication.class, args);
	}

}
