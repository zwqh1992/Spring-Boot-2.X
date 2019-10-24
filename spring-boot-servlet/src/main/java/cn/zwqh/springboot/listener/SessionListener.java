package cn.zwqh.springboot.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionIdListener, HttpSessionAttributeListener,
		HttpSessionActivationListener {

	/**
	 * session被创建时
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("===> session created");
	}

	/**
	 * session被销毁时
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("===> session destroyed");
	}

	/**
	 * sessionId改变
	 */
	@Override
	public void sessionIdChanged(HttpSessionEvent se, String oldSessionId) {
		System.out.println("===> session id changed");
	}

	/**
	 * session属性新增
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("===> session attribute added");
	}

	/**
	 * session属性移除
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("===> session attribute removed");
	}

	/**
	 * session属性替换
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("===> session attribute replaced");
	}
	/**
	 * session的钝化，内存的数据写入到硬盘上的过程。
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("===> session will passivate");
	}
	/**
	 * session的活化，将硬盘的数据恢复到内存中。
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("===> session did activate");
	}

}
