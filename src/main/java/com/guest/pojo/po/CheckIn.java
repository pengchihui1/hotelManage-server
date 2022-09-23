package com.guest.pojo.po;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 入住情况
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn extends Model<CheckIn> {

	/**
	 * 入住情况的id
	 */
	@TableId(value = "id")
	private Integer id;

	public CheckIn(int i, Object guestIdCard2, Object resultRoom, Timestamp fromTime2, Timestamp toTime2, int j) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CheckIn [id=" + id + ", guestIdCard=" + guestIdCard + ", roomId=" + roomId + ", fromTime=" + fromTime
				+ ", toTime=" + toTime + ", state=" + state + "]";
	}

	/**
	 * 客户的id
	 */
	private String guestIdCard;

	/**
	 * 房间号
	 */
	private String roomId;

	/**
	 * 入住日期
	 */
	private Timestamp fromTime;

	/**
	 * 预计退房时间
	 */
	private Timestamp toTime;

	/**
	 * 状态，0代表已退房，1代表正在入住
	 */
	private Integer state;

	public String getRoomId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Timestamp getFromTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Timestamp getToTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setState(int i) {
		// TODO Auto-generated method stub

	}

}
