package com.reqres.applicationApi;

import com.reqres.pojo.Users;

import io.restassured.response.Response;

public final class UserApi {
	
	private UserApi() {}
 	
	public static Response post(Users requestUsers) {
		return RestResource.post(requestUsers, Route.USERS);
	}
	
	public static Response get(int pageNo) {
		return RestResource.get(Route.TRANSACTIONS, pageNo);
	}
}
