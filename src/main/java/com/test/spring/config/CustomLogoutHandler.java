package com.test.spring.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public class CustomLogoutHandler implements LogoutHandler {

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
		
		HttpSession session = request.getSession(false);
		
		String logoutUserRole = request.getParameter("role");
		
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
			
		} else {
			try {
				response.sendRedirect("landing");
			} catch (Exception e) {}
		}
	}

}
