package com.reqres.apiVerification;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import com.reqres.applicationApi.StatusCode;
import com.reqres.pojo.Users;

public final class ApiVerification {

	private ApiVerification() {}
	
	public static void assertUserEquals(Users responseUsers, Users requestUsers) {
		assertThat(responseUsers.getName(), equalTo(requestUsers.getName()));
		assertThat(responseUsers.getJob(), equalTo(requestUsers.getJob()));
	}
	
	public static void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
		assertThat(actualStatusCode, equalTo(statusCode.code));
	}
}
