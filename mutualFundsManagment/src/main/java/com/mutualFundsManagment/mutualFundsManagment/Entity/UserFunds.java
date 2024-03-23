package com.mutualFundsManagment.mutualFundsManagment.Entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
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
@Entity
@ToString
public class UserFunds {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_info_id")
	@JsonIgnore
    private UserInfo userInfo;
	

	private String schemeCode;
	
	private double avgNav ;
	
	private double units;
	
	private Date lastBuyDate;
	
	private double totalAmount;
	
	private boolean isSold;
	
	
}
