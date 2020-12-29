package com.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.bean.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public List<SomeBean> getSomeBeanList() {
		return Arrays.asList(new SomeBean("propA-1", "propA-1", "propA-1"),
				new SomeBean("propB-1", "propB-1", "propB-1"), new SomeBean("propC-1", "propC-1", "propC-1"));
	}
}
