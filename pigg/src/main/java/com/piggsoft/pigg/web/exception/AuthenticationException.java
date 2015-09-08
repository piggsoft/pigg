/**
 * 
 */
package com.piggsoft.pigg.web.exception;

/**
 * @author piggsoft@gmail.com
 *
 */
public class AuthenticationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6306227263614479981L;

	/**
	 * 
	 */
	public AuthenticationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AuthenticationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AuthenticationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
