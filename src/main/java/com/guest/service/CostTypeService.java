package com.guest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.CostType;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 阿辉
 * @since 2020-12-02
 */

@Service
public interface CostTypeService extends IService<CostType> {

	List<CostType> getCostTypeByName(String name);

	List<CostType> getAllCostType();

	boolean removeByName(String name);
}
