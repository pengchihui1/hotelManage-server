package com.guest.pojo.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 客户
 * </p>
 *
 * @author 阿辉
 * @since 2020-12-02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest extends Model<Guest> {

	/**
	 * 客户的身份证号
	 */
	@TableId("id_card")
	private String idCard;

	public Guest(String idCard2, String name2, String contact2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Guest [idCard=" + idCard + ", name=" + name + ", contact=" + contact + "]";
	}

	/**
	 * 客户的姓名
	 */
	private String name;

	/**
	 * 客户的联系方式
	 */
	private String contact;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
