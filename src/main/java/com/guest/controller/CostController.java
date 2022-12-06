package com.guest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guest.pojo.po.Cost;
import com.guest.pojo.vo.Response;
import com.guest.pojo.vo.ResponseMsg;
import com.guest.service.CostService;
import com.guest.service.CostTypeService;
import com.guest.service.FrontService;
import com.guest.utils.JwtUtill;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
@CrossOrigin
@Transactional
@RestController
@Api(tags = { "消费记录" })
public class CostController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CostService costService;
	@Autowired
	private FrontService frontService;
	@Autowired
	private CostTypeService costTypeService;
	@Autowired
	private JwtUtill jwtUtill;
	private int insertCost;

	@PostMapping("/addCost")
	@ApiOperation(value = "添加/修改消费记录")
	@ApiImplicitParams({
//		@ApiImplicitParam(name = "Authorization", value = "填前台管理员的token", required = true),
			@ApiImplicitParam(name = "id", value = "消费记录的id,如果是添加记录直接填0，如果是修改就填修改的id", required = false),
			@ApiImplicitParam(name = "costTypeId", value = "消费类型的id", required = true),
			@ApiImplicitParam(name = "roomId", value = "房间的id", required = true),
			@ApiImplicitParam(name = "num", value = "消费类型的id", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response addCost(@RequestBody(required = false) Cost cost) {
		logger.info("咨询123", cost);
		Cost obj = costService.getCostById(cost.getId());
		if (!ObjectUtils.isEmpty(obj)) {
			boolean state = costService.saveOrUpdate(cost);
			return new Response().success(state);
		}
		if (ObjectUtils.isEmpty(obj)) {
			insertCost = costService.insertCost(cost);
			return new Response().success(insertCost);
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}

	@DeleteMapping("/deleteCost")
	@ApiOperation(value = "删除消费记录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "填前台管理员的token", required = true),
			@ApiImplicitParam(name = "id", value = "消费记录的id", required = true), })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response removeByRoomId(String id) {
		boolean state = costService.removeByRoomId(id);
		if (state) {
			return (new Response()).success(state);
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}

	@GetMapping("/getCostById")
	@ApiOperation(value = "通过id获取消费记录")
	@ApiImplicitParams({
//            @ApiImplicitParam(name="Authorization",value="填前台管理员的token",required=true),
			@ApiImplicitParam(name = "id", value = "消费记录的id", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40002, message = "数据不存在"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response getCostById(int id) {
		logger.info("对象：", id);
		Cost cost = costService.getById(id);
		if (cost != null) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("cost", cost);
			return new Response().success(resultMap);
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}

	/**
	 * 根据roomId查看全部消费记录，计算已结算和未结算的金额和总金额
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("/getCostByRoomId")
	@ApiOperation(value = "通过roomId查看当前入住客户的消费记录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "填前台管理员的token", required = true),
			@ApiImplicitParam(name = "roomId", value = "分配的房间的id", required = true), })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40002, message = "数据不存在"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response getCostByRoomId(String roomId) {
		List<Cost> costs = costService.getCostByRoomId(roomId);
		if (costs != null && costs.size() > 0) {
			return (new Response()).success(costs);
		}

		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}

	/**
	 * 根据roomId结算
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/settleCostByRoomId")
	@ApiOperation(value = "根据roomId结算")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "填前台管理员的token", required = true),
			@ApiImplicitParam(name = "roomId", value = "房间的id", required = true), })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response settleCostByRoomId(@RequestBody(required = false) String roomId) {
		// 将未结算的设置成已结算的
		boolean state = costService.settleCostByRoomId(roomId);
		return (new Response()).success(state);
	}

	/**
	 * 结算单条消费记录
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/settleCostById")
	@ApiOperation(value = "结算单条消费记录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "填前台管理员的token", required = true),
			@ApiImplicitParam(name = "id", value = "消费记录的id", required = true), })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40002, message = "数据不存在"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response settleCostById(int id) {
		Cost cost = costService.getById(id);
		if (cost != null) {
			cost.setState(11);
			boolean state = costService.saveOrUpdate(cost);
			return new Response().success(state);
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}
}
