package com.mutualFundsManagment.mutualFundsManagment.Service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.DTO.UserFundsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserFunds;
import com.mutualFundsManagment.mutualFundsManagment.Repo.MutalFundsDetailsRepo;
import com.mutualFundsManagment.mutualFundsManagment.Repo.UserFundRepo;
import com.mutualFundsManagment.mutualFundsManagment.Service.UserFundMangmentService;
import com.mutualFundsManagment.mutualFundsManagment.Utility.MutualFundMapper;

@Service
public class UserFundMangmentServiceImpl implements UserFundMangmentService {


	@Autowired
	private MutalFundsDetailsRepo mutalFundsDetailsRepo;
	
	@Autowired
	private MutualFundMapper mutualFundMapper;

	@Autowired
	private UserFundRepo userFundRepo;

	@Override
	public UserFunds buyFund(String schemeCode, double amount, UserInfo user) {

		MutualFundsDetails mutualFundDetails = mutalFundsDetailsRepo.findBySchemeCode(schemeCode);

		if (mutualFundDetails != null) {
			UserFunds userFunds = userFundRepo.getByUserIdAndSchemeCode(user.getUserId(), mutualFundDetails.getSchemeCode());
			double nav = Double.valueOf(mutualFundDetails.getNetAssetValue());
			double currUnit = amount / nav;
			if (userFunds != null) {
				double totalUnits = userFunds.getUnits();
				double averageNav = userFunds.getAvgNav();			
				double newUnit = totalUnits + currUnit;
				double newAverageNav = ((averageNav * totalUnits) + amount) / newUnit;
				userFunds.setAvgNav(newAverageNav);
				userFunds.setUnits(newUnit);
				userFunds.setAvgNav(nav);
				userFunds.setLastBuyDate(new Date());
				userFunds.setTotalAmount(newAverageNav*newUnit );
				userFunds.setSold(false);
			}
			else {
				userFunds = new UserFunds();
				userFunds.setSchemeCode(schemeCode);
				userFunds.setAvgNav(nav);
				userFunds.setUserInfo(user);
				userFunds.setUnits(currUnit);
				userFunds.setLastBuyDate(new Date());
				userFunds.setTotalAmount(amount);
				userFunds.setSold(false);
			
			}
			
			userFundRepo.save(userFunds);
			
			return userFunds;
		} else {
			// to do throw Exception
		}

		return null;
	}

	@Override
	public UserFundsDto sellFund(String schemeCode, UserInfo user) {
		
		MutualFundsDetails mutualFundDetails = mutalFundsDetailsRepo.findBySchemeCode(schemeCode);
		
		if (mutualFundDetails != null) {
			UserFunds userFunds = userFundRepo.getByUserIdAndSchemeCode(user.getUserId(), mutualFundDetails.getSchemeCode());
			if (userFunds != null) {
				UserFundsDto userFundsDto = mutualFundMapper.convertToDto(userFunds, UserFundsDto.class);
				
				
				double investedAmount = userFundsDto.getAvgNav() * userFundsDto.getUnits();
		
				double profitAmount =( Double.valueOf(mutualFundDetails.getNetAssetValue()) - Double.valueOf( userFundsDto.getAvgNav())) * userFundsDto.getUnits();

				double totalAmount = profitAmount + investedAmount;
				
				
				double profitPercentage = (profitAmount/investedAmount ) * 100;
				
				userFundsDto.setTotalAmount(totalAmount);
				userFundsDto.setProfitAmount(profitAmount);
				userFundsDto.setProfitPercentage(profitPercentage);
				
				//will create a boolean such that user can see the existing transaction so sold it also
				userFunds .setSold(true);
				userFundRepo.save(userFunds);
				
				return userFundsDto;
				
			}
			else {
				// exception user has no  such funds 
				
			}
			
		} else {
			// to do throw Exception
		}

	
		return null;
	}

}
