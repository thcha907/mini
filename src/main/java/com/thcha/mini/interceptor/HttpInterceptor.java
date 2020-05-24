package com.thcha.mini.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Component
public class HttpInterceptor extends HandlerInterceptorAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(HttpInterceptor.class); 

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("===============================================");
		logger.debug("==================== BEGIN ====================");
		logger.debug("- Request URI : " + request.getRequestURI());
		logger.debug("- Start Time : " + System.currentTimeMillis());
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.debug("- End Time : " + System.currentTimeMillis());
		logger.debug("==================== END ======================");
		logger.debug("===============================================");
	}

	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		logger.debug("- End Time : " + System.currentTimeMillis());
		logger.debug("============== Method Completed ===============");
		logger.debug("===============================================");
    }
}