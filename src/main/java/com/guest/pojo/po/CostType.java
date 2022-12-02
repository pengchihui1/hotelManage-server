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
 * @author 阿辉
 * @since 2020-12-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostType extends Model<CostType> {

	/**
	 * 消费类型的id
	 */
	private String id;

	/**
	 * 消费项目的名称
	 */
	private String name;

	/**
	 * 金额
	 */
	private Double money;

	@Override
	public String toString() {
		return "CostType [id=" + id + ", name=" + name + ", money=" + money + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
