package com.reqres.test;

import static com.reqres.apiVerification.ApiVerification.assertStatusCode;
import static com.reqres.apiVerification.ApiVerification.assertUserEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.reqres.builders.Builders.*;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import com.reqres.applicationApi.StatusCode;
import com.reqres.applicationApi.UserApi;
import com.reqres.pojo.Users;
import com.reqres.utils.DataUtils;

import io.restassured.response.Response;

public class UsersTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtils.class, dataProvider = "test-provider", timeOut = 5000, description = "Creating users using reqres api")
	public void creatUsersTest(Users users) {
		Users requestUsers = usersBuilder(users.getName(), users.getJob());
		Response response = UserApi.post(requestUsers);
		assertThat(response.getHeader("Content-Type"), CoreMatchers.containsString("application/json"));
		assertStatusCode(response.getStatusCode(), StatusCode.CODE_201);
		assertUserEquals(response.as(Users.class), requestUsers);
	}
}
