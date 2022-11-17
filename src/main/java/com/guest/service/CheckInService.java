package com.guest.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.CheckIn;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public interface CheckInService extends IService<CheckIn> {

	List<CheckIn> getValidCheckIns(Timestamp fromTime, Timestamp toTime);

	int getNum(String roomId);

	List<CheckIn> getByIdCard(String idCard);

	boolean removeByIdCard(String idCard);

	boolean removeByRoomId(String id);

	List<CheckIn> getValidCheckIns1(Timestamp fromTimeT, Timestamp toTimeT);

	List<CheckIn> getByIdCard(Object idCard);

	int getNum(Object roomId);
}
