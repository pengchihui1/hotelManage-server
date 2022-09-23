package com.guest;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
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
