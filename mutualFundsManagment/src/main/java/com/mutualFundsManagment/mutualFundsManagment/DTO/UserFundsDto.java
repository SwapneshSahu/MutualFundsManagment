package com.mutualFundsManagment.mutualFundsManagment.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserDetails;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	
    private UserDetails userDetails;
	
	
	private MutualFundsDetails mutualFundDetails;
	
	private double avgNav ;
	
	private double units;
	
	private Date lastBuyDate;
	
	private double profitPercentage;
	
	private double profitAmount;
	
	private double investedAmount;
	
	private double totalAmount;
	
	
}
