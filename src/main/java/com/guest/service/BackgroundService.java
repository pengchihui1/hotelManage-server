package com.guest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.Background;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public interface BackgroundService extends IService<Background> {
	/** 获取表的所有数据 */
	List<Background> getAll();

	/**
	 * 根据id查询表中对应的数据.
	 * 
	 * @param id
	 */
	Background selectUser(String backId, String password);

	Background getById(String backId);

	int insert(Background background);
}
