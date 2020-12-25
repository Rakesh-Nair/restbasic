package com.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import org.springframework.stereotype.Component;

import com.rest.webservices.restfulwebservices.bean.User;

import javassist.bytecode.Descriptor.Iterator;

@Component
public class UserService {

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
			user.setId(users.get(users.size() - 1).getId()+1);
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
	
	public User deleteById(Integer id) {
	Iterator<User> userItr = users.iterator();
		while(userItr.hasNext()) {
			User user = userItr.next();
			if(user.getId().equals(id)) {
				userItr.remove();
				return user;
			}
		}
		return null;
	}
}
