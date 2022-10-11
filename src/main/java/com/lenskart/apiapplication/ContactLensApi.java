package com.lenskart.apiapplication;

import java.util.Map;

import io.restassured.response.Response;

public class ContactLensApi {

	
	public static Response getShade(String session) {
		return RestResource.get(Route.SHADE, session);
	}
	
	public static Response getContactLens(String session, Map<String, Object> query) {
		return RestResource.get(Route.CONTACT_LENS, session, query);
	}
	
	
}
