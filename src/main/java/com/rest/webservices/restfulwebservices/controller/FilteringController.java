package com.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservices.restfulwebservices.bean.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filter")
	public List<SomeBean> getSomeBeanList() {
		return Arrays.asList(new SomeBean("propA-1", "propA-1", "propA-1"),
				new SomeBean("propB-1", "propB-1", "propB-1"), new SomeBean("propC-1", "propC-1", "propC-1"));
	}

	@GetMapping("/filter-dynamic")
	public MappingJacksonValue getSomeBeanDynamic() {

		SomeBean someBean = new SomeBean("propA-1", "propA-1", "propA-1");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		Set<String> properties = new HashSet<String>(Arrays.asList("prop1", "prop2"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}
}
