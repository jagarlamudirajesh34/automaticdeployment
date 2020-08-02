package com.test.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
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

	@Override
	public User getExternalUser(Long id) {
		try {
		    URL myURL = new URL("http://13.235.100.66:8083/mvn-hello-world/user/user/"+id);
		    URLConnection myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		    myURLConnection.getContent();
		    return (User) myURLConnection.getContent();
		} 
		catch (IOException e) {   
		    // openConnection() failed
		    // ...
			return null;
		}
		
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

}