package com.guest.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.Front;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public interface FrontService extends IService<Front> {

	Front getFrontById(String frontId);

	int insertFront(Front front);
}
