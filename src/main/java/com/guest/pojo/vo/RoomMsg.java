package com.guest.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 房间信息
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomMsg {
	/**
	 * 房间编号
	 */
	private String roomId;

	/**
	 * 房间的大小，以平方米为单位
	 */
	private Double size;

	/**
	 * 级别，分A,B,C,D级，级别依次降低
	 */
	private String rank;

	/**
	 * 租金，单位是人民币元
	 */
	private Double rent;

	/**
	 * 入住定金，单位是人民币元
	 */
	private Double earnest;

	/**
	 * 最大人数
	 */
	private Integer maxNum;

	public RoomMsg(String roomId2, Object size2, Object rank2, Object rent2, int earnest2, int maxNum2,
			Object position2, int i, String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RoomMsg [earnest=" + earnest + ", maxNum=" + maxNum + ", position=" + position + ", rank=" + rank
				+ ", rent=" + rent + ", roomId=" + roomId + ", size=" + size + ", state=" + state + ", time=" + time
				+ ", getRoomId()=" + getRoomId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	/**
	 * 地理位置
	 */
	private String position;
	/**
	 * 房间状态,1表示已经入住，0表示已被预定，-1表示空房间
	 */
	private Integer state;
	/**
	 * 入住/预定 时间
	 */
	private String time;

	public Object getRoomId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTime(String time2) {
		// TODO Auto-generated method stub

	}

	public void setState(int i) {
		// TODO Auto-generated method stub

	}
}