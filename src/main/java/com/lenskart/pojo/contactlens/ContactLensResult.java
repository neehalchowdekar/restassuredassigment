package com.lenskart.pojo.contactlens;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(value = {
		"is_ditto_enabled", 
		"category_power_urls", 
		"breadcrumb", 
		"personalisationApplied", 
		"parentHashtagList"
		})
public class ContactLensResult {
	
	private String id;
	@JsonProperty("num_of_products")
	private Integer numOfProducts;
	@JsonProperty("product_list")
	private List<Product> productList = null;

}
