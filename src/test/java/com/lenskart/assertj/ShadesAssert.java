package com.lenskart.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import com.lenskart.pojo.shades.Shades;
import com.lenskart.pojo.shades.ShadesResult;
import com.reqres.pojo.Users;

public class ShadesAssert  extends AbstractAssert<ShadesAssert, Shades>{

	private ShadesAssert(Shades actual, Class<?> selfType) {
		super(actual, selfType);
	}
	
	
	public static ShadesAssert assertThat(Shades result) {
		return new ShadesAssert(result, ShadesAssert.class);
	}
	
	
	public ShadesAssert hasColorShadeValue() {
		Assertions.assertThat(actual.getResult().get(0).getColorShade())
		.isNotEmpty()
		.isNotBlank()
		.withFailMessage("String is not empty or blank")
		.isExactlyInstanceOf(String.class);
		return this;
	}
	
	public ShadesAssert hasColorShadeUrl() {
		Assertions.assertThat(actual.getResult().get(0).getColorShadeUrl())
		.withFailMessage("String is not empty or blank")
		.isNotEmpty()
		.isNotBlank()
		.isExactlyInstanceOf(String.class)
		.withFailMessage("image is not .jpg/.png format")
		.containsAnyOf("jpg", "PNG", "png");
		return this;
	}
	
	

}
