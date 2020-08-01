package com.test.spring.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
										HttpServletResponse response, 
										Authentication authResult) 
												throws IOException, ServletException {
		
		Collection<? extends GrantedAuthority> auths = authResult.getAuthorities();
		
		String requestedUserRole = request.getParameter("role");
		for (GrantedAuthority authorities : auths)
		{
		    if (authorities.getAuthority().equals("ROLE_USER")){
		    	if(requestedUserRole != null && requestedUserRole.equals("user"))
		    	{
		    		request.getSession(true).setAttribute("username", authResult.getName());
		    		response.sendRedirect(response.encodeURL("user/profile"));
		    	}
		    	else
		    		response.sendRedirect(response.encodeURL("login?error&role="+requestedUserRole));
		    }
		    else if(authorities.getAuthority().equals("ROLE_ADMIN")){
		    	if(requestedUserRole != null && requestedUserRole.equals("admin"))
		    	{
		    		request.getSession(true).setAttribute("adminname", authResult.getName());
		    		response.sendRedirect(response.encodeURL("admin/home"));
		    	}
		    	else
		    		response.sendRedirect(response.encodeURL("login?error&role="+requestedUserRole));
		    } 
		}
	}

}
