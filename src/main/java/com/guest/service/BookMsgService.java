package com.guest.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.guest.pojo.po.BookMsg;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 张雪萍
 * @since 2020-11-27
 */
@Service
public interface BookMsgService extends IService<BookMsg> {

	List<BookMsg> getBookMsgByIdCard(String idCard);

	List<BookMsg> getBookMsgByTime(Timestamp fromTime, Timestamp toTime);

	boolean removeByIdCard(String idCard);

	boolean removeByResultRoom(String id);

	List<BookMsg> getBookMsgByTime1(Timestamp fromTimeT, Timestamp toTimeT);

	List<BookMsg> getBookMsgByIdCard(Object idCard);
}
