/**
 * 
 */
package com.piggsoft.pigg.web.spring.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author piggsoft@gmail.com
 *
 */
public class SystemInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);
		/*if (!isActive(session)) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}*/
		return super.preHandle(request, response, handler);
	}
	

}
