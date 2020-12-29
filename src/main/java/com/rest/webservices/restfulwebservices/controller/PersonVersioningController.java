package com.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.bean.Name;
import com.rest.webservices.restfulwebservices.bean.PersonV1;
import com.rest.webservices.restfulwebservices.bean.PersonV2;

@RestController
public class PersonVersioningController {

	@GetMapping("v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Rakesh Nair");
	}

	@GetMapping("v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Rakesh", "Nair"));
	}
}