/**
 * 
 */
package com.piggsoft.pigg.web.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author piggsoft@gmail.com
 * 
 */
public class CustomSimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver {
	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String viewName = determineViewName(ex, request);
		if (null != viewName) {
			if (isAjax(request)) {
				try {
					if (ex instanceof AuthenticationException) {
						response.sendError(HttpStatus.FORBIDDEN.value(), ex.getMessage());
						PrintWriter writer = response.getWriter();  
	                    writer.write(ex.getMessage());  
	                    writer.flush();  
					} else {
						response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
					}
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}  
				return new ModelAndView();
			}
		}
		return super.doResolveException(request, response, handler, ex);
	}

	/**
	 * @param request
	 * @return
	 */
	private boolean isAjax(HttpServletRequest request) {
		return (request.getHeader("X-Requested-With") != null && request
				.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1);
	}

}
