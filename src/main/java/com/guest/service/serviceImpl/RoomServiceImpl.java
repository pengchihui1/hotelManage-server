package com.guest.service.serviceImpl;

import java.util.List;

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
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
	@Autowired
	private RoomMapper roomMapper;

	@Override
	public List<Room> getRoomsByType(String rank) {
		return roomMapper.getRoomsByType(rank);
	}

	@Override
	public Room getById(Object roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRoom(Room room) {
		// TODO Auto-generated method stub
		int num = roomMapper.insertRoom(room);
		return num;
	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		List<Room> list = roomMapper.getAll();
		return list;
	}
}
