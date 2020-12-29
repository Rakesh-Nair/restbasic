package com.rest.webservices.restfulwebservices.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value = { "prop1" })
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	private String prop1;
	private String prop2;
	// @JsonIgnore
	private String prop3;

	public SomeBean(String prop1, String prop2, String prop3) {
		super();
		this.prop1 = prop1;
		this.prop2 = prop2;
		this.prop3 = prop3;
	}

	/**
	 * @return the prop1
	 */
	public String getProp1() {
		return prop1;
	}

	/**
	 * @param prop1 the prop1 to set
	 */
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	/**
	 * @return the prop2
	 */
	public String getProp2() {
		return prop2;
	}

	/**
	 * @param prop2 the prop2 to set
	 */
	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	/**
	 * @return the prop3
	 */
	public String getProp3() {
		return prop3;
	}

	/**
	 * @param prop3 the prop3 to set
	 */
	public void setProp3(String prop3) {
		this.prop3 = prop3;
	};

}
