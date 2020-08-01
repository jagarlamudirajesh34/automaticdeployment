package com.test.spring.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth)
																	throws IOException, ServletException {
		String userRole = request.getParameter("role");
		
		if(userRole != null) {
			response.sendRedirect(response.encodeURL("login?error&role="+userRole));
		} else {
			response.sendRedirect(response.encodeURL("landing"));
		}
	}

}
