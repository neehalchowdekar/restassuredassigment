package com.lenskart.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import com.lenskart.pojo.contactlens.ContactLens;
import com.lenskart.pojo.contactlens.Product;

public class ContactLensAssert  extends AbstractAssert<ContactLensAssert, ContactLens>{
	
	SoftAssertions softAssert = new SoftAssertions();

	private ContactLensAssert(ContactLens actual, Class<?> selfType) {
		super(actual, selfType);
	}
	
	
	public static ContactLensAssert assertThat(ContactLens result) {
		return new ContactLensAssert(result, ContactLensAssert.class);
	}
	
	
	public ContactLensAssert hasId() {
		Assertions.assertThat(actual.getContactLensResult().getId())
		.isNotEmpty()
		.isNotBlank()
		.withFailMessage("String is not empty or blank")
		.isExactlyInstanceOf(String.class);
		return this;
	}
	
	public ContactLensAssert hasNoOfProductMoreThanOne() {
		Assertions.assertThat(actual.getContactLensResult().getNumOfProducts())
		.withFailMessage("no product avalaible for give shade id")
		.isGreaterThanOrEqualTo(1);
		return this;
	}
	
	
	public ContactLensAssert idMatchesWithShadeId(String expectedShades) {
		Assertions.assertThat(actual.getContactLensResult().getId())
		.withFailMessage("Id did not match")
		.isEqualTo(expectedShades);
		return this;
	}
	
	public ContactLensAssert qtyShouldBeMoreThanOne() {
		for(Product product : actual.getContactLensResult().getProductList()) {
			int qty = product.getQty();
			String id = product.getId();
			softAssert.assertThat(qty)
			.withFailMessage( id + ": product quantity : ("+ qty + ") is lens than two")
			.isGreaterThan(2);
		}
		return this;
	}
	
	public void assertAll() {
		softAssert.assertAll();
	}
	
	
	
//	public ContactLensAssert qtyShouldbeMoreThanOne() {
//	boolean qty  = actual.getContactLensResult()
//			.getProductList()
//			.stream()
//			.allMatch(e -> e.getQty() > 1);
//	softAssert.assertThat(qty)
//	.withFailMessage("product quantity is lens than one")
//	.isTrue();
//	return this;
//}
	

}
