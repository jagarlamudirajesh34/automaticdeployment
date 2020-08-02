package com.test.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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
	public String getExternalUser(Long id) {
		try {
			URL url = new URL("http://13.235.100.66:8083/mvn-hello-world/user/user/"+id);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			//String output;
			//System.out.println("Output from Server .... \n");
			/*while ((output = br.readLine()) != null) {
				System.out.println(output);
			}*/
			return br.readLine();
		} 
		catch (IOException e) {   
		    // openConnection() failed
		    // ...
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String getUserById(Long id) {
		User user = userDao.getUserById(id);
		return user.getFirstName();
	}

}