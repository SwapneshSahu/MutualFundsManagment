package com.mutualFundsManagment.mutualFundsManagment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.DTO.MutualFundsDetailsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;

@Service
public interface MutualFundsDetailsService {
	
	List<MutualFundsDetails> getCurrentNav(String schemeCode); 
	
	void getHistoricalNav(String schemeCode , String  schemeName); 
	
	List<String> getAllFundHouses();

	List<String> getAllSchemeNamesByFundHouse(String fundHouse);

//	 List<MutualFundsDetails> saveHistoricalDate(List<MutualFundsDetailsDto> listDto);
	

}
