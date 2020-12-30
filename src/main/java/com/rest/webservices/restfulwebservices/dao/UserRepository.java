package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restfulwebservices.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
