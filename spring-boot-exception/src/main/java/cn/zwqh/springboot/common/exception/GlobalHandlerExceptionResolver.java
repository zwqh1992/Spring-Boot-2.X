package cn.zwqh.springboot.common.exception;

import java.lang.reflect.UndeclaredThrowableException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

	private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Exception e = new Exception();

		if (ex instanceof UndeclaredThrowableException) {
			e = (Exception) ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
		} else {
			e = ex;
		}
		e.printStackTrace();
		//这里可以根据不同异常引起的类做不同处理方式
		String exceptionName = ClassUtils.getShortName(e.getClass());
		if(exceptionName.equals("ArrayIndexOutOfBoundsException")) {
			log.error("GlobalHandlerExceptionResolver resolveException ===>" + exceptionName);
			ModelAndView mav = new ModelAndView();
			mav.addObject("stackTrace", e.getStackTrace());
			mav.addObject("exceptionName", exceptionName);
			mav.addObject("errorMessage", e.getMessage());
			mav.addObject("url", request.getRequestURL());
			mav.setViewName("forward:/error/500");
			return mav;
		}
		return null;
	}

}
