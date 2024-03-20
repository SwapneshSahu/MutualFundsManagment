package com.mutualFundsManagment.mutualFundsManagment.Service;

import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.DTO.UserFundsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserDetails;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserFunds;

@Service
public interface UserFundMangmentService {
	
	UserFunds buyFund(String schemeCode , double amount , UserDetails userDetails) ;

	UserFundsDto sellFund(String schemeCode, UserDetails user);
	

}
