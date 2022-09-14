package com.guest.pojo.po;

import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 预定房间的信息
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMsg extends Model<BookMsg> {

	/**
	 * 预定信息id
	 */
	@TableId(value = "id")
	private Integer id;

	public BookMsg(int i, Timestamp timestamp, Timestamp timestamp2, String idCard, String rank2, int j,
			Object object) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookMsg [id=" + id + ", fromTime=" + fromTime + ", toTime=" + toTime + ", guestIdCard=" + guestIdCard
				+ ", rank=" + rank + ", state=" + state + ", resultRoom=" + resultRoom + "]";
	}

	/**
	 * 预计入住时间
	 */
	private Timestamp fromTime;

	/**
	 * 预计退房时间
	 */
	private Timestamp toTime;

	/**
	 * 客户的身份证号
	 */
	private String guestIdCard;

	/**
	 * 预定的房间种类
	 */
	private String rank;

	/**
	 * 预定处理状态，0代表未处理，1代表已处理，11代表已入住(失效)
	 */
	private Integer state;

	/**
	 * 预定到的房间
	 */
	private String resultRoom;

	public Object getResultRoom() {
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

	public Object getGuestIdCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setState(int i) {
		// TODO Auto-generated method stub

	}

	public void setResultRoom(String roomId) {
		// TODO Auto-generated method stub

	}

	public void setFromTime(Timestamp timestamp) {
		// TODO Auto-generated method stub

	}

	public void setRank(String rank2) {
		// TODO Auto-generated method stub

	}

	public void setToTime(Timestamp timestamp) {
		// TODO Auto-generated method stub

	}

}
