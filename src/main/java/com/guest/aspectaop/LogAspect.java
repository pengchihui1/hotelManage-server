package com.guest.aspectaop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import eu.bitwalker.useragentutils.UserAgent;

@Aspect // 声明一个切面
@Component // 将该类加入到容器中
public class LogAspect {
	/* 注意在slf4j包下的 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 进入方法时间戳
	 */
	private Long startTime;
	/**
	 * 方法结束时间戳(计时)
	 */
	private Long endTime;

	/**
	 * 定义切点 通过doBefore doAfter实现处理拦截的信息
	 */
	@Pointcut("execution(* com.guest.controller..*.*(..))")
	public void log() {
	}

	/* 在进入controller之前处理流 */
	// JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象
	/**
	 * 前置通知： 1. 在执行目标方法之前执行，比如请求接口之前的登录验证; 2. 在前置通知中设置请求日志信息，如开始时间，请求参数，注解内容等
	 *
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		// 获取请求头中的User-Agent
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		// 打印请求的内容
		startTime = System.currentTimeMillis();
		logger.info("请求开始时间：{}" + LocalDateTime.now());
		logger.info("请求Url : {}" + request.getRequestURL().toString());
		logger.info("请求方式 : {}" + request.getMethod());
		logger.info("请求ip : {}" + request.getRemoteAddr());
		logger.info(
				"请求方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//		logger.info("请求参数 : {}" + Arrays.toString(joinPoint.getArgs()));
		// 只记录post方法 传json格式的数据
		if ("POST".equals(request.getMethod())) {
			LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
			String[] paramNames = u.getParameterNames(method);
			// 方法 1 请求的方法参数值 JSON 格式 null不显示
			if (joinPoint.getArgs().length > 0) {
				Object[] args = joinPoint.getArgs();
				for (int i = 0; i < args.length; i++) {
					// 请求参数类型判断过滤，防止JSON转换报错
					if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse
							|| args[i] instanceof MultipartFile) {
						continue;
					}
					logger.info("请求参数名称 :" + paramNames[i] + ", 内容 :" + JSON.toJSONString(args[i]));
				}
			}
		} else {
			// 请求的方法参数值 兼容fromDate格式和JSON格式
			Object[] args = joinPoint.getArgs();
			// 请求的方法参数名称 显示所有字段 值为null也显示该字段
			LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
			String[] paramNames = u.getParameterNames(method);
			if (args != null && paramNames != null) {
				String params = "";
				for (int i = 0; i < args.length; i++) {
					// 请求参数类型判断过滤，
					if (args[i] instanceof HttpServletRequest || args[i] instanceof HttpServletResponse
							|| args[i] instanceof MultipartFile) {
						continue;
					}
					params += " " + paramNames[i] + ": " + args[i] + ",";
				}
				logger.info("请求参数 :" + params);
			}
		}

		// 系统信息
		logger.info("浏览器：{}", userAgent.getBrowser().toString());
		logger.info("浏览器版本：{}", userAgent.getBrowserVersion());
		logger.info("操作系统: {}", userAgent.getOperatingSystem().toString());
	}

	/* 在进入controller之后处理流 */
	@After("log()")
	public void doAfter() {
		System.out.println("在进入controller之后处理流-------------");
	}

	/**
	 * 返回通知： 1. 在目标方法正常结束之后执行 1. 在返回通知中补充请求日志信息，如返回时间，方法耗时，返回值，并且保存日志信息
	 *
	 * @param ret
	 * @throws Throwable
	 */
	@AfterReturning(returning = "result", pointcut = "log()")
	public void doAfterReturning(Object result) {
		endTime = System.currentTimeMillis();
		logger.info("请求结束时间：{}" + LocalDateTime.now());
		logger.info("请求耗时：{}" + (endTime - startTime));
		// 处理完请求，返回内容
		logger.info("请求返回 : {}" + result);
	}

	/**
	 * 异常通知： 1. 在目标方法非正常结束，发生异常或者抛出异常时执行 1. 在异常通知中设置异常信息，并将其保存
	 *
	 * @param throwable
	 */
	@AfterThrowing(value = "log()", throwing = "throwable")
	public void doAfterThrowing(Throwable throwable) {
		// 保存异常日志记录
		logger.error("发生异常时间：{}" + LocalDateTime.now());
		logger.error("抛出异常：{}" + throwable.getMessage());
	}

}