package com.mutualFundsManagment.mutualFundsManagment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class MutualFundsDetailsDto {

	@JsonProperty("Scheme Code")
	private String schemeCode;
	

	@JsonProperty("Scheme Name")
	private String schemeName;

	@JsonIgnore
	@JsonProperty("ISIN Div Payout/ISIN Growth")
	 private String isinDivPayout;
	
	@JsonIgnore
	@JsonProperty("ISIN Div Reinvestment")
	  private String isinDivReinvestment;
	
	@JsonProperty("Net Asset Value")
	private String netAssetValue;

	@JsonProperty("Date")
	private String date;
	@JsonProperty("Scheme Type")
	private String schemeType;
	@JsonProperty("Scheme Category")
	private String schemeCategory;
	@JsonProperty("Mutual Fund Family")
	private String mutualFundFamily;
}
