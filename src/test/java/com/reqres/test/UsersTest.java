package com.reqres.test;

import static com.reqres.builders.Builders.usersBuilder;

import org.testng.annotations.Test;

import com.reqres.applicationApi.UserApi;
import com.reqres.assertj.ResponseAssert;
import com.reqres.pojo.Users;
import com.reqres.pojo.transactions.Transactions;
import com.reqres.utils.DataUtils;

import io.restassured.response.Response;

public class UsersTest extends BaseTest{
	
	@Test(dataProviderClass = DataUtils.class, dataProvider = "test-provider", timeOut = 5000, description = "Creating users using reqres api")
	public void creatUsersTest(Users users) {
		Users requestUsers = usersBuilder(users.getName(), users.getJob());
		Response response = UserApi.post(requestUsers);
		Users usersResponse = response.as(Users.class);
//		assertThat(response.getHeader("Content-Type"), CoreMatchers.containsString("application/json"));
//		assertStatusCode(response.getStatusCode(), StatusCode.CODE_201); 
//		assertUserEquals(response.as(Users.class), requestUsers);
		ResponseAssert.assertThat(response)
					  .isSuccessfulPostResponse()
					  .hasHeaderApplicationJson()
					  .canBeDeserialized(Users.class);
//		
//		UserAssert.assertThat(usersResponse)
//				  .hasSameResponse(requestUsers);
	}	
	
	@Test
	public void getUser() {
		for(int i = 0; i < 10; i++) {
			int randomUserId = AssignmentPractice.randomNumberGen(1, 10);
			int userId = AssignmentPractice.getuserid(randomUserId);
			Response response = UserApi.get(userId);
			String paymentOption = response.body().path("Payment_options"+ "[" + userId + "]");
		}
		
	}
	
	@Test(enabled = false)
	public void getTransactions() {
		//int pageNo = 1;
		double total = 0;
		Response response1 = UserApi.get(1);
		//Integer per_page = Integer.parseInt(response1.body().jsonPath().getJsonObject("per_page").toString());
		int pageNo = Integer.parseInt(response1.body().jsonPath().getJsonObject("total_pages").toString());
		while(pageNo != 0) {
			Response response = UserApi.get(pageNo);
			Integer per_page = Integer.parseInt(response.body().jsonPath().getJsonObject("per_page").toString());
			for(int i = 0; i < per_page; i++) {
				String userId = response.body().jsonPath().getJsonObject("data[" + i + "].userId").toString();
				String userName = response.body().jsonPath().getJsonObject("data[" + i + "].userName").toString();
				String txnType = response.body().jsonPath().getJsonObject("data[" + i + "].txnType").toString();
				if(userId.equals("1") && userName.equals("John Oliver") && (txnType.equals("debit") || txnType.equals("credit"))) {
					Double amount =  Double.parseDouble(response.body().jsonPath().getJsonObject("data[" + i + "].amount").toString().replaceAll("[$,]", ""));
					total += amount;
				}
			}
			pageNo--;
		}
		System.out.println("total amount is: " + total);
	}
	
	@Test(enabled = false)
	public void getTran() {
		double total = 0;
		Transactions response =  UserApi.get(1).as(Transactions.class);
		int pageNo = response.getTotalPages();
		while(pageNo != 0) {
			Transactions response1 = UserApi.get(pageNo).as(Transactions.class);
			int per_page = response1.getPerPage();
			for(int i = 0; i < per_page; i++) {
				int userId = response1.getData().get(i).getUserId();
				String userName = response1.getData().get(i).getUserName();
				String txnType = response1.getData().get(i).getTxnType();
				if(userId ==  1 && userName.equals("John Oliver") && 
						(txnType.equals("debit") || txnType.equals("credit"))) {
					Double amount = response1.getData().get(i).getAmount();
					total += amount;
				}
			}
			pageNo--;
		}
		System.out.println("total amount is: " + total);
		
	}
}
