package com.guest.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guest.mapper.BackgroundMapper;
import com.guest.pojo.po.Background;
import com.guest.service.BackgroundService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public class BackgroundServiceImpl extends ServiceImpl<BackgroundMapper, Background> implements BackgroundService {
	@Autowired
	private BackgroundMapper backgroundMapper;

	@Override
	public List<Background> getAll() {
		// TODO Auto-generated method stub
		List<Background> list = backgroundMapper.getAll();
		return list;
	}

	@Override
	public Background selectUser(String backId, String password) {
		// TODO Auto-generated method stub
		Background background = backgroundMapper.selectUser(backId, password);
		return background;
	}

	@Override
	public Background getById(String backId) {
		// TODO Auto-generated method stub
		Background background = backgroundMapper.getById(backId);
		return background;
	}

	@Override
	public int insert(Background background) {
		// TODO Auto-generated method stub

		return backgroundMapper.insert(background);
	}

}
