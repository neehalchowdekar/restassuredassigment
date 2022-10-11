package com.reqres.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import io.restassured.response.Response;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response>{

	// parameterised constructor
	private ResponseAssert(Response actual, Class<?> selfType) {
		super(actual, selfType);
	}
	
	public static ResponseAssert assertThat(Response response) {
		return new ResponseAssert(response, ResponseAssert.class);
	}
	
	public ResponseAssert isSuccessfulPostResponse() {
		Assertions.assertThat(actual.getStatusCode())
				  .withFailMessage(() -> "Status code is not 201")
				  .isEqualTo(201);
		return this;
	}
	
	public ResponseAssert isSuccessfulGetResponse() {
		Assertions.assertThat(actual.getStatusCode())
				  .withFailMessage(() -> "Status code is not 200")
				  .isEqualTo(200);
		return this;
	}
	
	public ResponseAssert hasHeaderApplicationJson() {
		Assertions.assertThat(actual.header("Content-type"))
				  .withFailMessage(() -> "Header with Content type as Application/json is not present")
				  .contains("application/json");
		return this;
	}
	
	public <T> T canBeDeserialized(Class<T> clazz) {
		return actual.as(clazz);
//		return this;
	}

}
