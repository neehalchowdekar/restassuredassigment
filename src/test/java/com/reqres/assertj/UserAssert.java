package com.reqres.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import com.reqres.pojo.Users;

public class UserAssert  extends AbstractAssert<UserAssert, Users>{

	private UserAssert(Users actual, Class<?> selfType) {
		super(actual, selfType);
	}
	
	
	public static UserAssert assertThat(Users person) {
		return new UserAssert(person, UserAssert.class);
	}
	
	public UserAssert hasSameResponse(Users user) {
		Assertions.assertThat(actual)
				  .withFailMessage("response is different")
				  .isEqualTo(user);
		return this;
	}
	

}
