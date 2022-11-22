package com.guest.service.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guest.mapper.RoomMapper;
import com.guest.pojo.po.Room;
import com.guest.service.RoomService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoomMapper dao;

	@Override
	public List<Room> getRoomsByType(String rank) {
		return dao.getRoomsByType(rank);
	}

	@Override
	public Room getById(String id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public int insert(Room room) {
		// TODO Auto-generated method stub
		return dao.insert(room);
	}

	@Override
	public int update(Room room) {
		return dao.update(room);
	}

	@Override
	public boolean deleteById(String id) {
		return dao.deleteById(id);
	}

	@Override
	public List<Room> findAll() {
		List<Room> rooms = dao.findAll();
		return rooms;
	}

}
