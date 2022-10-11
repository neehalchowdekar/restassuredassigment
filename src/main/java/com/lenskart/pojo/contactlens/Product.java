package com.lenskart.pojo.contactlens;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

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
//@JsonIgnoreProperties({
//	"image_url",
//	"image_url_suffix",
//	"imageUrls",
//	"product_url",
//	"brand_name",
//	"model_name",
//	"prices",
//	"is_tbyb",
//	"tags",
//	"color_options",
//	"totalColorAvailable",
//	"is_ditto",
//	"classification",
//	"specifications",
//	"wishlistCount",
//	"purchaseCount",
//	"avgRating",
//	"totalNoOfRatings",
//	"hashtagList",
//	"offerName",
//	"clUsage",
//	"arModelAndroidUrl",
//	"arModelIOSUrl",
//	"arModelMsiteAndDesktopUrl",
//	"arModelOriginalUrl",
//	"suited_for",
//	"brand_logo",
//	"subCollection",
//	"offer_image"
//})

@JsonIncludeProperties({"qty", "id"})
public class Product {
	
	public Integer qty;
	public String id;

}
