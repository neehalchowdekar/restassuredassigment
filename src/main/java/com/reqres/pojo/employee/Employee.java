package com.reqres.pojo.employee;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Employee {
	
	private int id;
	private boolean isFTE;
	private String fname;
	private Address address;
	private List<String> roles;

}
