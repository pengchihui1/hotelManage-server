package com.guest.pojo.po;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 消费类型
 * </p>
 *
 * @author 张雪萍
 * @since 2020-12-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostType extends Model<CostType> {

	/**
	 * 消费类型的id
	 */
	private Integer id;

	/**
	 * 消费项目的名称
	 */
	private String name;

	/**
	 * 金额
	 */
	private Double money;

	public CostType(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}

	public CostType(int i, String string, Object rent) {
		// TODO Auto-generated constructor stub
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setMoney(int i) {
		// TODO Auto-generated method stub

	}

	public void setMoney(Object rent) {
		// TODO Auto-generated method stub

	}

}