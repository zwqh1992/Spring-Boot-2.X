package cn.zwqh.springboot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.zwqh.springboot.common.interceptor.PageInterceptor;
import cn.zwqh.springboot.common.interceptor.Test1Interceptor;
import cn.zwqh.springboot.common.interceptor.Test2Interceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	/*
	 * 拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册自定义拦截器，添加拦截路径和排除拦截路径
		registry.addInterceptor(new Test1Interceptor()) // 添加拦截器1
				.addPathPatterns("/**") // 添加拦截路径
				.excludePathPatterns(// 添加排除拦截路径
						"/hello","/page")
				.order(0);
		registry.addInterceptor(new Test2Interceptor()) // 添加拦截器2
				.addPathPatterns("/**") // 添加拦截路径
				.excludePathPatterns(// 添加排除拦截路径
						"/test1","/page")
				.order(1);
		registry.addInterceptor(new PageInterceptor()) // 添加拦截器page
		.addPathPatterns("/page") // 添加拦截路径
		.order(2);
		super.addInterceptors(registry);
	}

}
