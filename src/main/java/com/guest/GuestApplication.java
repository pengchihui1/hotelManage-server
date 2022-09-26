package com.guest;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * spring boot工程都有一个启动引导类，这是工程的入口类 并在引导类上添加@SpringBootApplication
 */
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
//扫描mybatis所有的业务mapper接口
@MapperScan("com.guest.mapper")
@EnableSwagger2
public class GuestApplication {
	@PostConstruct
	void started() {// 设置时区
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}

	public static void main(String[] args) {
		SpringApplication.run(GuestApplication.class, args);
	}
}
