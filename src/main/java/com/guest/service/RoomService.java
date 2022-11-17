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
 * @author 阿辉
 * @since 202-11-12
 */
@Service
public interface RoomService extends IService<Room> {

//	类型查询及翻页查询
	public List<Room> getRoomsByType(String rank);

//	获得所有及翻页 
//	public List<Room> findAll();

//	单个查询
	public Room getById(String id);

//	新增
	public int insert(Room room);

//	修改
	public int update(Room room);

//	删除
	boolean deleteById(String id);

}
