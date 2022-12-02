package com.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guest.pojo.po.CostType;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 阿辉
 * @since 2020-12-02
 */
@Mapper
@Repository
public interface CostTypeMapper extends BaseMapper<CostType> {
	List<CostType> getCostTypeByName(String name);

	List<CostType> getAllCostType();

	boolean removeByName(String name);

	int insertCostType(CostType costType);

	int updateCostType(CostType costType);

	boolean removeByCostTypeId(String costTypeId);
}
