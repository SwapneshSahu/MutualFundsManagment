package com.mutualFundsManagment.mutualFundsManagment.Service;

import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.DTO.UserFundsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserFunds;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;

@Service
public interface UserFundMangmentService {
	
	UserFunds buyFund(String schemeCode , double amount , UserInfo userDetails) ;

	UserFundsDto sellFund(String schemeCode, UserInfo user);
	

}
