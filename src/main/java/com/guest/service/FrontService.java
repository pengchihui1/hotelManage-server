package com.guest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.Front;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public interface FrontService extends IService<Front> {

	List<Front> getFrontAlls();

	Front getFrontById(String frontId);

	int insertFront(Front front);

	int updateFront(Front front);

	boolean removeByFrontId(String frontId);

	Front frontLogin(String frontId, String password);
}
