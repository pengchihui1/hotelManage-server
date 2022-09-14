package com.guest.service.serviceImpl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guest.mapper.CheckInMapper;
import com.guest.pojo.po.CheckIn;
import com.guest.service.CheckInService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public class CheckInServiceImpl extends ServiceImpl<CheckInMapper, CheckIn> implements CheckInService {
	@Autowired
	private CheckInMapper checkInMapper;

	@Override
	public List<CheckIn> getValidCheckIns(Timestamp fromTime, Timestamp toTime) {
		return checkInMapper.getValidCheckIns(fromTime, toTime);
	}

	@Override
	public int getNum(String roomId) {
		return checkInMapper.getNum(roomId);
	}

	@Override
	public List<CheckIn> getByIdCard(String idCard) {
		return checkInMapper.getByIdCard(idCard);
	}

	@Override
	public boolean removeByIdCard(String idCard) {
		return checkInMapper.removeByIdCard(idCard);
	}

	@Override
	public boolean removeByRoomId(String id) {
		return checkInMapper.removeByRoomId(id);
	}

	@Override
	public List<CheckIn> getValidCheckIns1(Timestamp fromTimeT, Timestamp toTimeT) {
		return checkInMapper.getValidCheckIns1(fromTimeT, toTimeT);
	}

	@Override
	public List<CheckIn> getByIdCard(Object idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNum(Object roomId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
