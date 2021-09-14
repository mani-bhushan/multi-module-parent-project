package com.apps.org.custom.exceptions;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Thrown if an {@link UserDetailsService} implementation can locate a {@link User} by
 * its userName.
 *
 * @author Mani Bhushan
 */
public class UserNameFoundException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4926468583005150708L;

	/**
	 * Constructs a <code>UsernameNotFoundException</code> with the specified message.
	 * @param msg the detail message.
	 */
	public UserNameFoundException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a {@code UsernameNotFoundException} with the specified message and root
	 * cause.
	 * @param msg the detail message.
	 * @param cause root cause
	 */
	public UserNameFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
