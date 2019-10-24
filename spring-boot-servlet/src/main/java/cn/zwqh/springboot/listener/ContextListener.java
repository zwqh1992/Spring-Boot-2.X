package cn.zwqh.springboot.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener, ServletContextAttributeListener{

	public static final String INITIAL_CONTENT = "Content created in servlet Context";

	/**
	 * ServletContext创建
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("===> context initialized");
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("content", INITIAL_CONTENT);
	}

	/**
	 * ServletContext销毁
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("===> context destroyed");
	}

	/**
	 * context属性新增
	 */
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("===> context attribute added");
	}

	/**
	 * context属性移除
	 */
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("===> context attribute removed");
	}

	/**
	 * context属性替换
	 */
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("===> context attribute replaced");
	}
}
