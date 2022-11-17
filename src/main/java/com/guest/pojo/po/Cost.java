package com.guest.pojo.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 花费情况
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cost extends Model<Cost> {

	/**
	 * 消费信息的id
	 */
	@TableId(value = "id")
	private Integer id;

	@Override
	public String toString() {
		return "Cost [id=" + id + ", costTypeId=" + costTypeId + ", roomId=" + roomId + ", num=" + num + ", state="
				+ state + "]";
	}

	/**
	 * 消费项目
	 */
	private Integer costTypeId;

	/**
	 * 入住的id
	 */
	private String roomId;

	/**
	 * 入住的id
	 */
	private Integer num;

	/**
	 * 状态，0表示未结算，1表示已结算
	 */
	private Integer state;

	public Cost(Integer id, Integer costTypeId, String roomId, Integer num, Integer state) {
		this.id = id;
		this.costTypeId = costTypeId;
		this.roomId = roomId;
		this.num = num;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCostTypeId() {
		return costTypeId;
	}

	public void setCostTypeId(Integer costTypeId) {
		this.costTypeId = costTypeId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Cost(int id2, int costTypeId2, String roomId2, int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public Cost(int id2, int id3, Object resultRoom, int i, int j) {
		// TODO Auto-generated constructor stub
	}

}
