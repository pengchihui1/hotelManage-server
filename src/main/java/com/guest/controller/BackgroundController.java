package com.guest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guest.pojo.po.Background;
import com.guest.pojo.vo.Response;
import com.guest.pojo.vo.ResponseMsg;
import com.guest.service.BackgroundService;
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
 * @author 张雪萍
 * @since 2020-11-27
 */
@CrossOrigin
@Transactional
@RestController
@Api(tags = { "后端管理员" })
public class BackgroundController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BackgroundService backgroundService;// 接口功能
	@Autowired
	private JwtUtill jwtUtill;

	@RequestMapping("/backgroundLogin")
	@ResponseBody
	@ApiOperation(value = "后台管理员登录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true),
			@ApiImplicitParam(name = "password", value = "后台管理员的密码", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不存在"),
			@ApiResponse(code = 40105, message = "密码错误,请核对后重新输入"), @ApiResponse(code = 40005, message = "该用户不存在") })
	public Response backgroundLogin(@RequestBody(required = false) Background background) {
		Background background1 = backgroundService.getById(background.getBackId());
		if (background1 != null) {
			if (background1.getPassword().equals(background.getPassword())) {
				String token = jwtUtill.updateJwt(background.getBackId());
				return (new Response()).success(token);
			}
			return new Response(ResponseMsg.PASSWORD_WRONG);
		}
		return new Response(ResponseMsg.NO_SUCH_USER);
	}

	@PostMapping("/test")
	public String test() {
		Background background = backgroundService.selectUser("admin", "123456");
		return "123456";
	}

}
