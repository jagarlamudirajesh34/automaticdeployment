package com.test.service;

import java.util.List;

import com.test.modal.User;

public interface UserService {

	User getUser(String mobile);
	
	List<User> getAllActiveUsers();
	
	List<User> getAllInActiveUsers();
	
	User getExternalUser(Long id);
	
	User getUserById(Long id);

}