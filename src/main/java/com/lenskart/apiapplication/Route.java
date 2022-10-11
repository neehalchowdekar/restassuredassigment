package com.lenskart.apiapplication;

public final class Route {
	
	private Route() {}

	public static final String V2 = "/v2";
	public static final String USERS = "/users";
	public static final String TRANSACTIONS = "/transactions";
	public static final String CONTACT_LENS = "/products/category/contact-lens";
	public static final String SHADE =  CONTACT_LENS + "/shade";
	
}
