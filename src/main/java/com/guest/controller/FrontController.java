package com.guest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.guest.pojo.po.Front;
import com.guest.pojo.vo.Response;
import com.guest.pojo.vo.ResponseMsg;
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
//@RequestMapping("front")
@Api(tags = { "前台管理员" })
public class FrontController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FrontService frontService;

	@Autowired
	private JwtUtill jwtUtill;

	@PostMapping("/addFront")
	@ApiOperation(value = "添加前台账号")
	@ApiImplicitParams({
//				@ApiImplicitParam(name = "Authorization", value = "填后台管理员的token", required = false),
			@ApiImplicitParam(name = "frontId", value = "前台管理员的工号", required = false),
			@ApiImplicitParam(name = "name", value = "前台管理员的姓名", required = false),
			@ApiImplicitParam(name = "password", value = "前台管理员的密码", required = true),
			@ApiImplicitParam(name = "phone", value = "前台管理员的电话", required = false) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response addFront(@RequestBody(required = false) Front front) {
//		logger.info("咨询", front);
		if (front.getFrontId() != null) {
			Front frontOne = frontService.getFrontById(front.getFrontId());
			if (!ObjectUtils.isEmpty(frontOne)) {
				int number = frontService.updateFront(front);
				return (new Response()).success(number);
			} else {
				return new Response(ResponseMsg.NO_SUCH_USER);
			}
		} else {
			int number = frontService.insertFront(front);
			if (number == 1) {
				return (new Response()).success(number);
			}
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);

	}

	@DeleteMapping("/deleteFront")
	@ApiOperation(value = "删除前台账号")
	@ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "填后台管理员的token", required = true),
			@ApiImplicitParam(name = "frontId", value = "要删除的前台员工的账号id，", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response removeByFrontId(String frontId) {
		logger.info("咨询内容", frontService.getFrontById(frontId));
		if (frontService.getFrontById(frontId) != null) {
			Boolean bool = frontService.removeByFrontId(frontId);
			return new Response().success(bool);
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}

//	@DeleteMapping(value = "/deleteFront/{frontId}")
//	@ApiOperation(value = "删除前台账号")
//	public Response removeByFrontId(@PathVariable String frontId) {
//		logger.info("咨询内容", frontId);
//		if (frontService.getFrontById(frontId) != null) {
//			frontService.removeByFrontId(frontId);
//			return new Response().success();
//		}
//		return new Response(ResponseMsg.ILLEGAL_OPERATION);
//	}

	@PostMapping("/frontLogin")
	@ApiOperation(value = "前台登录")
	@ApiImplicitParams({
//		@ApiImplicitParam(name = "Authorization", value = "token，不填", required = false),
			@ApiImplicitParam(name = "frontId", value = "前台员工的账号id，", required = true),
			@ApiImplicitParam(name = "password", value = "密码", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40105, message = "密码错误,请核对后重新输入"),
			@ApiResponse(code = 40005, message = "该用户不存在") })
	public Response frontLogin(@RequestBody(required = false) Front front) {
		Front ft = frontService.frontLogin(front.getFrontId(), front.getPassword());
		if (!ObjectUtils.isEmpty(ft)) {
			return (new Response()).success(ft);
		}
		return new Response(ResponseMsg.NO_SUCH_USER);
	}

//	@GetMapping("/getAllFront")
//	@ApiOperation(value = "获取所有的前台账号")
//	@ApiImplicitParams({ @ApiImplicitParam(name = "Authorization", value = "token，填后台管理员的token", required = true), })
//	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40002, message = "数据不存在"),
//			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
//	public Response getAllFront(HttpServletRequest request) {
//		String num = (String) request.getAttribute("num");
//		if (frontService.getById(num) != null) {
//			List<Front> fronts = frontService.list();
//			if (fronts != null && fronts.size() > 0) {
//				Map<String, Object> resultMap = new HashMap<>();
//				String token = jwtUtill.updateJwt(num);
//				resultMap.put("fronts", fronts);
//				resultMap.put("token", token);
//				return (new Response()).success(resultMap);
//			}
//			return new Response(ResponseMsg.NO_TARGET);
//		}
//		return new Response(ResponseMsg.ILLEGAL_OPERATION);
//	}

	@GetMapping("/getAllFronts")
	@ApiOperation(value = "获取所有的前台账号")
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40002, message = "数据不存在"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response getAllFront() {
		List<Front> fronts = frontService.getFrontAlls();
		if (fronts != null && fronts.size() > 0) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("fronts", fronts);
			return new Response().success(resultMap);
		}

		return new Response(ResponseMsg.ILLEGAL_OPERATION);
	}

	@GetMapping("/getFrontById")
	@ApiOperation(value = "通过职工id获取前台账号")
	@ApiImplicitParams({ @ApiImplicitParam(name = "frontId", value = "前台员工的账号id，", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 40002, message = "数据不存在"),
			@ApiResponse(code = 40104, message = "非法操作, 试图操作不属于自己的数据") })
	public Response getFrontById(HttpServletRequest request, String frontId) {
		Front front = frontService.getFrontById(frontId);
		logger.info("front:", front);
		if (front != null) {
			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("front", front);
			return (new Response()).success(resultMap);
		}
		return new Response(ResponseMsg.ILLEGAL_OPERATION);

	}
}
