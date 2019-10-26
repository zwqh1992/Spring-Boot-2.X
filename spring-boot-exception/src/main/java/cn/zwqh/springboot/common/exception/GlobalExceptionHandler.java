package cn.zwqh.springboot.common.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) {
		log.error("ExceptionHandler ===>" + e.getMessage());
		e.printStackTrace();
		// 这里可根据不同异常引起的类做不同处理方式
		String exceptionName = ClassUtils.getShortName(e.getClass());
		log.error("ExceptionHandler ===>" + exceptionName);
		ModelAndView mav = new ModelAndView();
		mav.addObject("stackTrace", e.getStackTrace());
		mav.addObject("exceptionName", exceptionName);
		mav.addObject("errorMessage", e.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("forward:/error/500");
		return mav;
	}
}
