package com.guest.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guest.mapper.CostTypeMapper;
import com.guest.pojo.po.CostType;
import com.guest.service.CostTypeService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-12-02
 */
@Service
public class CostTypeServiceImpl extends ServiceImpl<CostTypeMapper, CostType> implements CostTypeService {
	@Autowired
	private CostTypeMapper costTypeMapper;

	@Override
	public List<CostType> getCostTypeByName(String name) {
		return costTypeMapper.getCostTypeByName(name);
	}

	@Override
	public List<CostType> getAllCostType() {
		return costTypeMapper.getAllCostType();
	}

	@Override
	public boolean removeByName(String name) {
		return costTypeMapper.removeByName(name);
	}

	@Override
	public int insertCostType(CostType costType) {
		// TODO Auto-generated method stub
		return costTypeMapper.insertCostType(costType);
	}

	@Override
	public int updateCostType(CostType costType) {
		// TODO Auto-generated method stub
		return costTypeMapper.updateCostType(costType);
	}

	@Override
	public boolean removeByCostTypeId(String costTypeId) {
		// TODO Auto-generated method stub
		return costTypeMapper.removeByCostTypeId(costTypeId);
	}
}
