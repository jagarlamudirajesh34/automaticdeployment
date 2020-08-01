package com.test.spring.config;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);
		
		String logoutUserRole = request.getParameter("role");
		
		SecurityContext securityContext = SecurityContextHolder.getContext();
		
		if(session != null) {
			
			if(logoutUserRole != null) {
				
				switch(logoutUserRole) {
				
					case "admin": 
								session.removeAttribute("adminname");
								break;
								
					case "user":
								session.removeAttribute("username");
								break;
								
				}
			}
			
			boolean isAdminSessionAlive = false;
			boolean isUserSessionAlive = false;
			
			if(session.getAttribute("adminname") != null)
				isAdminSessionAlive = true;
			if(session.getAttribute("username") != null)
				isUserSessionAlive = true;
			
			if(!isAdminSessionAlive && !isUserSessionAlive)
				session.invalidate();
			else {
				//Include dummy authentication object to spring security context to continue with other user sessions logged in from the different tabs of the same browser
				Authentication authentication = new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), null);
				securityContext.setAuthentication(authentication);
			}
			
		}
		
		try {
			response.sendRedirect("landing");
		} catch (Exception e) {}

	}

}

