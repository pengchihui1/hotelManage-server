package com.guest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 阿辉
 * @since 202-11-12
 */
//重写 WebMvcConfigurer(全局跨域)
@Configuration
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// 添加映射路径 .addMapping("/cors/**")
		registry.addMapping("/**")
				// 允许哪些原始域进行跨域访问
				.allowedOrigins("*")
				// 放行哪些请求方式 允许所有的请求方法
				.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
				// 是否发送 Cookie
				.allowCredentials(true)
				// cookie有效日期
				.maxAge(3600)
				// 放行哪些原始请求头部信息
				.allowedHeaders("*");
		// .allowedHeaders("Origin, X-Requested-With, Content-Type, Accept")
		// 暴露哪些头部信息
		// .exposedHeaders(HttpHeaders.SET_COOKIE)
		// .maxAge(3600L)
	}
}

//@WebFilter(filterName = "CorsFilter")
//@Configuration
//public class CorsConfig implements Filter {
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletResponse response = (HttpServletResponse) res;
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//		chain.doFilter(req, res);
//	}
//}
