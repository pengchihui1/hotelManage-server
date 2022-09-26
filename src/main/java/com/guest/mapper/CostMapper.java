package com.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guest.pojo.po.Cost;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Mapper
@Repository
public interface CostMapper extends BaseMapper<Cost> {
	List<Cost> getCostByRoomId(String roomId);

	boolean settleCostByRoomId(String roomId);

	boolean removeByRoomId(String roomId);

	int getNotCostNum(String roomId);

	boolean removeByCostTypeId(Integer id);

	int insertCost(Cost cost);

	Cost getCostById(Integer id);
}
