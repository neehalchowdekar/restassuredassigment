package com.lenskart.apiapplication;

import static com.reqres.config.ConfigFactory.*;

import java.util.HashMap;
import java.util.Map;

import com.reqres.config.ConfigFactory;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class SpecBuilder {

	private SpecBuilder() {
	}

	public static RequestSpecification getRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri(getConfig().baseUri())
				.setBasePath(Route.V2)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
	}
	
	public static RequestSpecification getRequestSpec(String sessionToken) {
		return new RequestSpecBuilder()
				.setBaseUri(getConfig().baseUri())
				.setBasePath(Route.V2)
				.setContentType(ContentType.JSON)
				.addHeaders(headers(sessionToken))
				.log(LogDetail.ALL)
				.build();
	}

	public static ResponseSpecification getResponseSpec() {
		return new ResponseSpecBuilder().
		// expectContentType(ContentType.JSON).
				log(LogDetail.ALL).build();
	}
	
	
	private static Map<String, String> headers(String sessionToken){
		Map<String, String> header = new HashMap<>();
		header.put("X-Api-Client", ConfigFactory.getConfig().client());
		header.put("x-country-code", ConfigFactory.getConfig().countryCode());
		header.put("X-Session-Token", sessionToken);
		return header;
		
		
	}

}
