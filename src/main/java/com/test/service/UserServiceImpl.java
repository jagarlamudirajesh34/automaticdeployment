package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDao;
import com.test.modal.User;

@Service("userService")
@Transactional("transactionManager")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getUser(String mobile) {
		return userDao.getUser(mobile);
	}

	@Override
	public List<User> getAllActiveUsers() {
		return userDao.getAllActiveUsers();
	}
	
	@Override
	public List<User> getAllInActiveUsers() {
		return userDao.getAllInActiveUsers();
	}

}