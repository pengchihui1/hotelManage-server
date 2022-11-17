package com.guest.pojo.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 前台管理的账号
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Front extends Model<Front> {

	/**
	 * 前台管理员的工号
	 */
	@TableId(value = "front_id")
	private String frontId;

	@Override
	public String toString() {
		return "Front [frontId=" + frontId + ", name=" + name + ", password=" + password + ", phone=" + phone + "]";
	}

	/**
	 * 前台管理员的姓名
	 */
	private String name;

	/**
	 * 前台管理的登录密码
	 */
	private String password;

//	public Front() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * 前台管理员的电话
	 */
	private String phone;

	public String getFrontId() {
		return frontId;
	}

	public void setFrontId(String frontId) {
		this.frontId = frontId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Front(String frontId, String name, String password, String phone) {
		this.frontId = frontId;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

}
