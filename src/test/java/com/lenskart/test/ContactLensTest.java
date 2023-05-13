package com.lenskart.test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lenskart.apiapplication.ContactLensApi;
import com.lenskart.apiapplication.TrendingApi;
import com.lenskart.assertj.ContactLensAssert;
import com.lenskart.assertj.ResponseAssert;
import com.lenskart.assertj.ShadesAssert;
import com.lenskart.pojo.contactlens.ContactLens;
import com.lenskart.pojo.shades.Shades;
import com.lenskart.pojo.trending.Result;

import io.restassured.response.Response;

public class ContactLensTest {
	
	private static List<String> shadeIds;
	
	public static final String session = "22f6cedd-0a01-4e91-9803-e87b223e1ab4";
	
	@Test(priority = 1)
	public void getShades() {
	 Response response =  ContactLensApi.getShade("22f6cedd-0a01-4e91-9803-e87b223e1ab4");
		
	 Shades	shades = ResponseAssert
			 	.assertThat(response)
				.isSuccessfulGetResponse()
				.hasHeaderApplicationJson()
				.canBeDeserialized(Shades.class);
				
	 ShadesAssert.assertThat(shades)
				.hasColorShadeValue()
				.hasColorShadeUrl();
		
	 shadeIds = shades.getResult()
				.stream()
				.map(e -> e.getColorShadeId())
				.collect(Collectors.toList());
		
	}
	
	
	@Test(priority = 2, dataProvider = "getData")
	public void getContactLens(String expectedShadeId) {
		
	 Response contactLensResponse = ContactLensApi
			 	.getContactLens("22f6cedd-0a01-4e91-9803-e87b223e1ab4", 
			 					Map.of("colorShadeId", expectedShadeId));
		
	 ContactLens contactLens = ResponseAssert
		.assertThat(contactLensResponse)
		.isSuccessfulGetResponse()
		.hasHeaderApplicationJson()
		.canBeDeserialized(ContactLens.class); 
		
	 ContactLensAssert
		.assertThat(contactLens)
		.hasId()
		.hasNoOfProductMoreThanOne()
		.idMatchesWithShadeId(expectedShadeId)
		.qtyShouldBeMoreThanOne()
		.assertAll();
	 
		}
	
	
	@Test
	public static void validateTrendingProducts(String expectedQuery) {
		Response response =  TrendingApi.getTrendingProduct("22f6cedd-0a01-4e91-9803-e87b223e1ab4");
		
		Result result = response.as(Result.class);
		
		
		for(int i = 0; i < result.getSearches().size(); i++) {
			String actualQuery = result.getSearches().get(i).getQuery();
			String label = result.getSearches().get(i).getLabel();
			assertEquals(actualQuery, expectedQuery);
		}
		
	}
	@DataProvider
	public Object[][] getData(){
		return shadeIds.stream()
			   .map(shade -> new Object[] {shade})
			   .toArray(Object[][] :: new);
	}

}
