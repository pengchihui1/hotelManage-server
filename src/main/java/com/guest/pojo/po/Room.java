package com.guest.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 房间信息
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room extends Model<Room> {

	/**
	 * 房间编号
	 */
	@TableId(value = "room_id", type = IdType.ID_WORKER)
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

	/**
	 * 地理位置
	 */
	private String position;

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", size=" + size + ", rank=" + rank + ", rent=" + rent + ", earnest="
				+ earnest + ", maxNum=" + maxNum + ", position=" + position + "]";
	}

	public String getRoomId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEarnest() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRank() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getMaxNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
