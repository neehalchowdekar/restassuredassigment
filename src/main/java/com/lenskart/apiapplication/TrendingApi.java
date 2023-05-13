/**
 * 
 */
package com.lenskart.apiapplication;

import io.restassured.response.Response;

/**
 * @author neehalc (neehalc@zeta.tech)
 *
 */
public class TrendingApi {
	
	
	public static Response getTrendingProduct(String sessionToken) {
		return RestResource.get(sessionToken, Route.TRENDING);
	}

}
