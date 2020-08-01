package com.test.dao;

import java.util.List;

import com.test.modal.User;

public interface UserDao extends Dao {

	User getUser(String mobile);
	
	List<User> getAllUsers();

}