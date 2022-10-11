package com.reqres.template;

import java.util.Arrays;

import com.reqres.pojo.employee.Address;
import com.reqres.pojo.employee.Employee;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmployeeTemplate implements TemplateLoader {

	@Override
	public void load() {
		
		Fixture.of(Employee.class).addTemplate("valid", new Rule() {
			{
				add("id", random(Integer.class, range(100, 1000)));
				add("fname", random("neehal", "mallu", "kapil"));
				add("isFTE", random(true, false));
				add("roles", uniqueRandom(Arrays.asList("tester"), Arrays.asList("manager")));
				add("address", random(new Address("some stree", "Kalaburgi")));
			}
		});
		
		Fixture.of(Employee.class).addTemplate("invalidId", new Rule() {
			{
				add("id", random(Integer.class, range(1, 3)));
				add("fname", random("neehal", "mallu", "kapil"));
				add("isFTE", random(true, false));
				add("roles", uniqueRandom(Arrays.asList("tester"), Arrays.asList("manager")));
				add("address", random(new Address("some stree", "Kalaburgi")));
			}
		});
		
		Fixture.of(Employee.class).addTemplate("invalidFname").inherits("valid", new Rule() {
			{
				add("fname", random("neeh-al", "ma-llu", "ka-pil"));
			}
		});
		
	}

}
