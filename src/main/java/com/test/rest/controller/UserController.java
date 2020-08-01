package com.test.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.modal.User;
import com.test.service.UserService;
import com.test.util.ServiceStatus;

@RestController
@RequestMapping("/user")
public class UserController {

	private TokenStore tokenStore;

	@Autowired
	UserService userService;

	// for getting all Active courses details
	@RequestMapping(value = "/getAllActiveUsers", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ServiceStatus getAllActiveCourses() {
		ServiceStatus serviceStatus = new ServiceStatus();
		try {
			List<User> allActiveUsers = userService.getAllUsers();
			if(allActiveUsers != null && !allActiveUsers.isEmpty()){
				serviceStatus.setStatus("success");
				serviceStatus.setMessage("Retrived All Active Users Successfully");
				serviceStatus.setResult(allActiveUsers);
			}else{
				serviceStatus.setStatus("failure");
				serviceStatus.setMessage("No Active users found");
			}
			serviceStatus.setStatus("success");
			serviceStatus.setMessage("Retrived All Active Users Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			serviceStatus.setStatus("failure");
			serviceStatus.setMessage("Exception occured");
			serviceStatus.setResult(e.fillInStackTrace());
		}
		return serviceStatus;
	}

}
