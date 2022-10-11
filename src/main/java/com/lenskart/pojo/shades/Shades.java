package com.lenskart.pojo.shades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Shades {
	
	
	private List<ShadesResult> result;

}
