package com.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restfulwebservices.bean.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
