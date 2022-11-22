package com.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guest.pojo.po.Background;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Mapper
@Repository
public interface BackgroundMapper extends BaseMapper<Background> {

	List<Background> getAll();

	Background selectUser(String backId, String password);

	Background getById(String backId);

	int insert(Background background);

	boolean remove(String backId);
}
