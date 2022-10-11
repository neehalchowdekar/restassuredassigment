package com.lenskart.pojo.shades;

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
public class ShadesResult {
	
	
	private Integer colorId;
	private String colorShadeId;
	private String colorShade;
	private String colorShadeUrl;
	

}
