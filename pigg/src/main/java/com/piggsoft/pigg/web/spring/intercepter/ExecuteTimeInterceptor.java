package com.piggsoft.pigg.web.spring.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ExecuteTimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory
			.getLogger(ExecuteTimeInterceptor.class);
	
	private static final String REQUEST_START_TIME = ExecuteTimeInterceptor.class.getName() + "." + "startTime";

	// before the actual handler will be executed
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute(REQUEST_START_TIME, startTime);
		return true;
	}

	// after the handler is executed
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		long startTime = (Long) request.getAttribute(REQUEST_START_TIME);

		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;

		// log it
		if (logger.isDebugEnabled()) {
			logger.debug("[" + handler + "] executeTime : " + executeTime
					+ "ms");
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (null != ex) {
			logger.error(ex.getMessage(), ex);
		}
	}
}