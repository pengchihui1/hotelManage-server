package com.guest.pojo.po;

import java.io.Serializable;

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
 * @author 张雪萍
 * @since 2020-11-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cost extends Model<Cost> {

	public Cost(int i, Object id2, String resultRoom, int j, int k) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 消费信息的id
	 */
	@TableId(value = "id")
	private Integer id;

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

	public void setState(int i) {
		// TODO Auto-generated method stub

	}

	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Serializable getCostTypeId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
