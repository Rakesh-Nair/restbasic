package com.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.bean.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList();
	static {
		users.add(new User(1,"Ichiji", new Date()));
		users.add(new User(2,"Niji", new Date()));
		users.add(new User(3,"Sanji", new Date()));
		users.add(new User(4,"Yonji", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(users.size()+1);
		}
		users.add(user);
		return user;	
	}
	
	public User findOne(Integer id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
}
