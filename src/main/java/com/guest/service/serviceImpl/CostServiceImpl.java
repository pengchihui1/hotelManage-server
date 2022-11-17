package com.guest.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guest.mapper.CostMapper;
import com.guest.pojo.po.Cost;
import com.guest.service.CostService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements CostService {
	@Autowired
	private CostMapper costMapper;

	@Override
	public List<Cost> getCostByRoomId(String roomId) {
		return costMapper.getCostByRoomId(roomId);
	}

	@Override
	public boolean settleCostByRoomId(String roomId) {
		return costMapper.settleCostByRoomId(roomId);
	}

	@Override
	public boolean removeByRoomId(String roomId) {
		return costMapper.removeByRoomId(roomId);
	}

	@Override
	public int getNotCostNum(String roomId) {
		return costMapper.getNotCostNum(roomId);
	}

	@Override
	public boolean removeByCostTypeId(Integer id) {
		return costMapper.removeByCostTypeId(id);
	}

	@Override
	public void removeByRoomId(Object roomId) {
		// TODO Auto-generated method stub

	}

	@Override
	public int insertCost(Cost cost) {
		// TODO Auto-generated method stub
		return costMapper.insertCost(cost);
	}

	@Override
	public Cost getCostById(Integer id) {
		// TODO Auto-generated method stub
		return costMapper.getCostById(id);
	}
}
