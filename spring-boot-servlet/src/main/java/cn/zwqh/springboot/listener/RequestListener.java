package cn.zwqh.springboot.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener {
	/**
	 * 请求即将进入Web应用程序的范围/请求初始化时
	 */
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("===> request initialized");
	}
	/**
	 * 请求即将进入Web应用程序的范围/请求销毁时
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("===> request destroyed");
	}
	/**
	 * request属性新增
	 */
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("===> request attribute added");
	}
	/**
	 * request属性移除
	 */
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("===> request attribute removed");
	}
	/**
	 * request属性替换
	 */ 
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("===> request attribute replaced");
	}
}
