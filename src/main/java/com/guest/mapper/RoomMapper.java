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
 * @author 阿辉
 * @since 202-11-12
 */
@Mapper
@Repository
public interface RoomMapper extends BaseMapper<Room> {

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
