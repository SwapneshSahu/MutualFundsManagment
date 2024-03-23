package com.mutualFundsManagment.mutualFundsManagment.DTO;

import java.util.Date;

import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;

import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserFundsDto {

	
	
    private Long id;
	
	
    private UserInfo userInfo;
	
	
	private MutualFundsDetails mutualFundDetails;
	
	private double avgNav ;
	
	private double units;
	
	private Date lastBuyDate;
	
	private double profitPercentage;
	
	private double profitAmount;
	
	private double investedAmount;
	
	private double totalAmount;
	
	
}
