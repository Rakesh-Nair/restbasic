package com.rest.webservices.restfulwebservices.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.bean.*;

import com.rest.webservices.restfulwebservices.dao.UserDaoService;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveAUser(@PathVariable Integer id){
		return userDaoService.findOne(id);
	}
}
