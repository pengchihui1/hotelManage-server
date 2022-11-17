package com.guest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guest.pojo.po.Front;

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
public interface FrontMapper extends BaseMapper<Front> {

	Front getFrontById(String frontId);

	int insertFront(Front front);

}
