package cn.zwqh.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * 静态资源配置
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	
		super.addResourceHandlers(registry);
		
	}

	/**
	 * 视图控制器配置
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {	
		registry.addViewController("/").setViewName("/index");//设置默认跳转视图为 /index
		registry.addViewController("/error/500").setViewName("/error/500");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
		
		
	}
	/**
	 * 视图解析器配置  控制controller String返回的页面    视图跳转控制 
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	    super.configureViewResolvers(registry);
	}
	
}
