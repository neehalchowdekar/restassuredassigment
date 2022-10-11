package com.reqres.pojo.employee;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@ToString
public class Address {
	
	private String street;
	private String city;

}
