package com.practice;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.reqres.pojo.employee.Address;
import com.reqres.pojo.employee.Employee;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class FixtureTests {
	
	@Test
	public void getFixtureData() {
		
		Fixture.of(Employee.class).addTemplate("valid", new Rule() {
			{
				add("id", random(Integer.class, range(100, 1000)));
				add("fname", random("neehal", "mallu", "kapil"));
				add("isFTE", random(true, false));
				add("roles", uniqueRandom(Arrays.asList("tester"), Arrays.asList("manager")));
				add("address", random(new Address("some stree", "Kalaburgi")));
			}
		});
		
		
		List<Employee> valid =  Fixture.from(Employee.class).gimme(10,"valid");
		valid.forEach(System.out::println);
	}

}
