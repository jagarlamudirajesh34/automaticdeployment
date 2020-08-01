package com.test.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.test.modal.User;
import com.test.security.UserRepositoryUserDetails;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	public CustomUserDetailsService() {
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("checked");
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		User user = userService.getUser(username);
		System.out.println(username);
		System.err.println(user);
		System.err.println(request.getParameter("password"));
		if(user != null && user.getDeletedYn() == true)
		{
			System.err.println(1);
			throw new UsernameNotFoundException(String.format("User %s is Blocked by Admin!", username));
		}
		if(user != null && request.getParameter("roleId") != null && Long.parseLong(request.getParameter("roleId")) != user.getUserRole().getId()){
			System.err.println(2);
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		if(user != null && !user.getPassword().equals(request.getParameter("password"))){
			System.err.println(3);
			throw new UsernameNotFoundException(String.format("Password missmatched!", username));
		}
		System.err.println(4);
		return new UserRepositoryUserDetails(user, user.getId());
	}
}

