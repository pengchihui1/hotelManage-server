package com.guest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.Cost;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public interface CostService extends IService<Cost> {

	List<Cost> getCostByRoomId(String roomId);

	boolean settleCostByRoomId(String roomId);

	boolean removeByRoomId(String roomId);

	int getNotCostNum(String roomId);

	boolean removeByCostTypeId(Integer id);

	void removeByRoomId(Object roomId);
}
