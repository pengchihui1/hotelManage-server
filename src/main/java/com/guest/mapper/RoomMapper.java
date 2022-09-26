package com.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guest.pojo.po.Room;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Mapper
@Repository
public interface RoomMapper extends BaseMapper<Room> {
	List<Room> getRoomsByType(String rank);

	int insertRoom(Room room);

	List<Room> getAll();
}
