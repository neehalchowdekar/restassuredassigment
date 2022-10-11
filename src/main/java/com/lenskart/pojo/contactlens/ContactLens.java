package com.lenskart.pojo.contactlens;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lenskart.pojo.shades.Shades;
import com.lenskart.pojo.shades.ShadesResult;

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
@JsonIgnoreProperties(value = {"status","traceId"})
public class ContactLens {
	
	
	@JsonProperty("result")
	private ContactLensResult contactLensResult;

}
