package com.lenskart.apiapplication;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import com.reqres.config.ConfigFactory;
import com.reqres.config.FrameworkConfig;

import io.restassured.response.Response;

public final class RestResource {
	
	private RestResource() {}
	
	
	public static Response post(Object payload, String path) {

		return given(SpecBuilder.getRequestSpec())
				.body(payload)
				.when()
				.post(path)
				.then()
				.spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	public static Response get(String path, String sessionToken) {
		return given(SpecBuilder.getRequestSpec(sessionToken))
				.when()
				.get(path)
				.then()
				.spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	public static Response get(String path, String sessionToken, Map<String, Object> queryparams) {
		return given(SpecBuilder.getRequestSpec(sessionToken))
				.queryParams(queryparams)
				.when()
				.get(path)
				.then()
				.spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
}
