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
//消费项目对应的结算信息，比如早餐502房间定了3份100元，已付费
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cost extends Model<Cost> {

	/**
	 * 消费信息的id
	 */
	@TableId(value = "id")
	private String id;

	/**
	 * 消费项目
	 */
	private int costTypeId;

	/**
	 * 数量
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCostTypeId() {
		return costTypeId;
	}

	public void setCostTypeId(int costTypeId) {
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

	@Override
	public String toString() {
		return "Cost [id=" + id + ", costTypeId=" + costTypeId + ", roomId=" + roomId + ", num=" + num + ", state="
				+ state + "]";
	}

	public Cost(String id, int costTypeId, String roomId, Integer num, Integer state) {
		this.id = id;
		this.costTypeId = costTypeId;
		this.roomId = roomId;
		this.num = num;
		this.state = state;
	}

}
