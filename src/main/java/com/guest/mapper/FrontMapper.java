package com.guest.mapper;

import java.util.List;

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

	List<Front> getFrontAlls();

	Front getFrontById(String frontId);

	Front frontLogin(String frontId, String password);

	int insertFront(Front front);

	int updateFront(Front front);

	boolean removeByFrontId(String frontId);
}
