package com.mutualFundsManagment.mutualFundsManagment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class MutualFundsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("Scheme Code")
	private String schemeCode;

	@JsonProperty("Scheme Name")
	private String schemeName;

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
