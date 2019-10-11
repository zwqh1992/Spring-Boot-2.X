package cn.zwqh.springboot.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

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

	/**
	 * 跨域配置
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")// 配置允许跨域的路径
				.allowedOrigins("*")// 配置允许访问的跨域资源的请求域名
				.allowedMethods("PUT,POST,GET,DELETE,OPTIONS")// 配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
				.allowedHeaders("*"); // 配置允许请求header的访问，如 ：X-TOKEN
		super.addCorsMappings(registry);
	}
//	@Autowired
//	private BeforMethodInteceptor beforMethodInteceptor;
//	/**
//	 * 拦截器配置
//	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {	
//		//注册自定义拦截器，添加拦截路径和排除拦截路径
//		registry.addInterceptor(beforMethodInteceptor) //添加拦截器
//                   .addPathPatterns("/**") //添加拦截路径
//                   .excludePathPatterns(//添加排除拦截路径
//                           "/index",
//                           "/login",
//                           "/doLogin",
//                           "/logout",
//                           "/register",
//                           "/doRegister",
//                           "/**/*.css",
//				"/**/*.png", 
//                           "/**/*.jpeg",
//                           "/**/*.jpg",
//                           "/**/*.ico",
//                           "/**/*.js",
//                           "/swagger-resources/**"
//                           );
//		super.addInterceptors(registry);		
//	}

	/**
	 * 视图控制器配置
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/index");// 设置默认跳转视图为 /index
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/article").setViewName("/article");
		registry.addViewController("/error/403").setViewName("/error/403");
		registry.addViewController("/error/404").setViewName("/error/404");
		registry.addViewController("/error/500").setViewName("/error/500");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

	
	/**
	 * 消息转换器配置
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		/**
		 * 自定义字符串转换器
		 */
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		converters.add(converter);
		/**
		 * 自定义fastjson转换器
		 */
		super.configureMessageConverters(converters);
		// 1.需要定义一个convert转换消息的对象;
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		// 2.添加fastJson的配置信息，比如：是否要格式化返回的json数据;
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 3处理中文乱码问题
		List<MediaType> fastMediaTypes = new ArrayList<>();
		fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		// 4.在convert中添加配置信息.
		fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		// 5.将convert添加到converters当中.
		converters.add(fastJsonHttpMessageConverter);
	}

	/**
	 * 数据格式化器配置
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		super.addFormatters(registry);
		registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
	}
	
	/**
	 * 视图解析器配置 控制controller String返回的页面 视图跳转控制
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".html");
		viewResolver.setCache(false);
		viewResolver.setContentType("text/html;charset=UTF-8");
		viewResolver.setOrder(0);		
		registry.viewResolver(viewResolver);
		super.configureViewResolvers(registry);
	}

}
