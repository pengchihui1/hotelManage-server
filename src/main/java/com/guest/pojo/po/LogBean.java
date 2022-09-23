package com.guest.pojo.po;

import java.util.Date;

import lombok.Data;

@Data // Lombok注解
public class LogBean {
	private Long id;
	// 操作userId
	private String userId;
	// 模块
	private String module;
	// 操作
	private String action;
	// 描述信息
	private String describe;
	// 接口地址
	private String api;
	// GET POST DELETE PUT...
	private String method;
	// 接口参数信息
	private String paramJson;
	// 操作时间
	private Date restTime;
}
