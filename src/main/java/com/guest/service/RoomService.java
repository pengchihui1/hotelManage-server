package com.guest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.Room;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public interface RoomService extends IService<Room> {

	List<Room> getRoomsByType(String rank);

	Room getById(Object roomId);

	int insertRoom(Room room);

	List<Room> getAll();
}
