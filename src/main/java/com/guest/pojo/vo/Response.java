package com.guest.pojo.vo;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Data
public class Response<T> implements Serializable {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/** 返回信息码 */
	private int code;
	/** 返回信息内容 */
	private String msg;

	private T data = null;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp = new Date();

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", msg=" + msg + ", data=" + data + ", timestamp=" + timestamp + "]";
	}

	public Response() {
	}

	// 只能返回定义的返回信息
	// 根据异常类构造
	public Response<T> success(T data) {
		this.code = ResponseMsg.SUCCESS.code;
		this.msg = ResponseMsg.SUCCESS.msg;
		this.data = data;
		logger.info("数据处理：", this);
		return this;
	}

	public Response success() {
		logger.info("执行了");
		return new Response(ResponseMsg.SUCCESS);
	}

	public Response(ResponseMsg msg) {
		this.code = msg.code;
		this.msg = msg.msg;
	}
}
