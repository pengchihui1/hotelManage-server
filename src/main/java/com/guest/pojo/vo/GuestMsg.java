package com.guest.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 客户的身份信息和入住信息
 * </p>
 *
 * @author 阿辉
 * @since 2020-12-02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestMsg {
	/**
	 * 客户的身份证号
	 */
	@TableId("id_card")
	private String idCard;

	/**
	 * 客户的姓名
	 */
	private String name;

	public GuestMsg(String idCard2, String name2, String contact2, int i, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GuestMsg [idCard=" + idCard + ", name=" + name + ", contact=" + contact + ", state=" + state
				+ ", roomId=" + roomId + "]";
	}

	/**
	 * 客户的联系方式
	 */
	private String contact;

	/**
	 * 如果是1表示已入住，如果是0表示已预定，如果是-1表示已退房
	 */
	private Integer state;

	/**
	 * 房间号
	 */
	private String roomId;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

}
