package cn.zwqh.springboot.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zwqh.springboot.model.UserEntity;

@WebServlet(urlPatterns = "/TestServlet")
public class TestServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3325041776508043481L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("RequestURI:" + req.getRequestURI());

		System.out.println("Request Headers:");

		StringBuilder sb = new StringBuilder();
		Enumeration<?> names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement().toString();
			Enumeration<?> hs = req.getHeaders(name);
			sb.append(name).append(":");
			while (hs.hasMoreElements()) {
				sb.append(hs.nextElement()).append(";");
			}
		}
		System.out.println(sb);
		
		ObjectMapper om=new ObjectMapper();
		UserEntity user=new UserEntity();
		user.setId(1L);
		user.setUserName("zwqh");
		user.setUserSex("男");
		user.setHeaders(sb.toString());
		String resultJson=om.writeValueAsString(user);

		resp.setContentType("application/json;charset=UTF-8");
		
		resp.getWriter().print(resultJson);
	}

}
