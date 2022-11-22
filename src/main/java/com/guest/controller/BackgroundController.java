package com.guest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @author 阿辉
 * @since 202-11-12
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

	@PostMapping(value = "/backgroundLogin")
	@ApiOperation(value = "后台管理员登录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true),
			@ApiImplicitParam(name = "password", value = "后台管理员的密码", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不存在"),
			@ApiResponse(code = 40105, message = "密码错误,请核对后重新输入"), @ApiResponse(code = 40005, message = "该用户不存在") })
	public Response backgroundLogin(HttpServletRequest request, Background background) {
		Background background1 = backgroundService.getById(background.getBackId());

		if (background1 != null) {
			if (background1.getPassword().equals(background.getPassword())) {
				String token = jwtUtill.updateJwt(background.getBackId());

				return (new Response()).success(token);
			}
			logger.info(null, new Response(ResponseMsg.PASSWORD_WRONG));
			return new Response(ResponseMsg.PASSWORD_WRONG);
		}
		return new Response(ResponseMsg.NO_SUCH_USER);
	}

//	@RequestMapping
	@PostMapping("/test")
	@ApiOperation(value = "后台管理员登录")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true),
			@ApiImplicitParam(name = "password", value = "后台管理员的密码", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "请求成功"), @ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不存在"),
			@ApiResponse(code = 40105, message = "密码错误,请核对后重新输入"), @ApiResponse(code = 40005, message = "该用户不存在") })
	public Response test(@RequestBody(required = false) Background background) {

		Background background1 = backgroundService.selectUser("admin", "123456");
		logger.info("115:" + background1);
		if (background1 != null) {
			if (background1.getPassword().equals(background.getPassword())) {
				String token = jwtUtill.updateJwt(background.getBackId());
				logger.info("111");
				return (new Response()).success(background1);
			}
			logger.info("222");
			return new Response(ResponseMsg.PASSWORD_WRONG);
		}
		logger.info("333");
		return new Response(ResponseMsg.NO_SUCH_USER);
	}

	@PostMapping("/addbackground")
	@ApiOperation(value = "后台管理员新增")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true),
			@ApiImplicitParam(name = "password", value = "后台管理员的密码", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Background.class) })
	public Response insert(@RequestBody(required = false) Background background) {

		int value = backgroundService.insert(background);
		logger.info("115:" + value);
		if (value == 1) {
			return new Response(ResponseMsg.SUCCESS);
		}
		return new Response(ResponseMsg.FAIL);
	}

	@PostMapping("/removeBackground")
	@ApiOperation(value = "后台管理员新增")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Background.class) })
	public Response remove(@RequestBody(required = false) String backId) {

		Boolean value = backgroundService.remove(backId);
		if (value == true) {
			return new Response(ResponseMsg.SUCCESS);
		}
		return new Response(ResponseMsg.FAIL);
	}

	@GetMapping("/getById")
	@ApiOperation(value = "后台管理员单个查询")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Background.class) })
	public Response getById(String backId) {
		Background background = backgroundService.getById(backId);
		if (background != null) {

			return new Response(ResponseMsg.SUCCESS);
		}
		return new Response(ResponseMsg.FAIL);
	}

	@GetMapping("/getAll")
	@ApiOperation(value = "后台管理员所有")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Background.class) })
	public Response getAll() {
		List<Background> list = backgroundService.getAll();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		return new Response().success(resultMap);
	}

	@GetMapping("/selectUser")
	@ApiOperation(value = "后台管理员一个用户")
	@ApiImplicitParams({ @ApiImplicitParam(name = "backId", value = "后台管理员的工号", required = true),
			@ApiImplicitParam(name = "password", value = "后台管理员的密码", required = true) })
	@ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Background.class) })
	public Response selectUser(String backId, String password) {
		Background background = backgroundService.selectUser(backId, password);
		if (background != null) {
			return new Response(ResponseMsg.SUCCESS);
		}
		return new Response(ResponseMsg.FAIL);
	}
}
