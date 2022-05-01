package com.reqres.builders;

import com.reqres.pojo.Users;

public final class Builders {
	
	private Builders() {}
	
	public static Users usersBuilder(String name, String job) {
		return Users.builder().name(name).job(job).build();
	}

}
