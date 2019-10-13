package cn.zwqh.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * 静态资源配置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");// 静态资源路径 css,js,img等
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");// 视图
		registry.addResourceHandler("/mapper/**").addResourceLocations("classpath:/mapper/");// mapper.xml
		super.addResourceHandlers(registry);
	}
}
