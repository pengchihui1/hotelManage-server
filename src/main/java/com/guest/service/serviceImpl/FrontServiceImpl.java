package com.guest.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guest.mapper.FrontMapper;
import com.guest.pojo.po.Front;
import com.guest.service.FrontService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public class FrontServiceImpl extends ServiceImpl<FrontMapper, Front> implements FrontService {
	@Autowired
	private FrontMapper frontMapper;

	@Override
	public List<Front> getFrontAlls() {
		// TODO Auto-generated method stub
		return frontMapper.getFrontAlls();
	}

	@Override
	public Front getFrontById(String frontId) {
		// TODO Auto-generated method stub
		return frontMapper.getFrontById(frontId);
	}

	@Override
	public int insertFront(Front front) {
		// TODO Auto-generated method stub
		return frontMapper.insert(front);
	}

	@Override
	public int updateFront(Front front) {
		// TODO Auto-generated method stub
		return frontMapper.updateFront(front);
	}

	@Override
	public boolean removeByFrontId(String frontId) {
		// TODO Auto-generated method stub
		return frontMapper.removeByFrontId(frontId);
	}

	@Override
	public Front frontLogin(String frontId, String password) {
		// TODO Auto-generated method stub
		return frontMapper.frontLogin(frontId, password);
	}

}
