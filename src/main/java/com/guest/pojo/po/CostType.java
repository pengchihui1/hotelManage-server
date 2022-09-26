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

	public CostType(int i, String string, int j) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CostType [id=" + id + ", name=" + name + ", money=" + money + "]";
	}

	/**
	 * 金额
	 */
	private Double money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}
