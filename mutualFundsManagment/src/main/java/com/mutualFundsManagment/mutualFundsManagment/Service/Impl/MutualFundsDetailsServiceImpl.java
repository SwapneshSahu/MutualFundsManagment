package com.mutualFundsManagment.mutualFundsManagment.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.DTO.MutualFundsDetailsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;
import com.mutualFundsManagment.mutualFundsManagment.Repo.MutalFundsDetailsRepo;
import com.mutualFundsManagment.mutualFundsManagment.Service.MutualFundsDetailsService;
import com.mutualFundsManagment.mutualFundsManagment.Utility.MutualFundMapper;

@Service
public class MutualFundsDetailsServiceImpl implements MutualFundsDetailsService{

	@Autowired
	private MutalFundsDetailsRepo mutalFundsDetailsRepo;
	
	@Autowired
	private MutualFundMapper mutualFundMapper;
	
	@Override
	public List<MutualFundsDetails> getCurrentNav(String schemeCode) {
		
		return mutalFundsDetailsRepo.findAllBySchemeCode(schemeCode);
		
	}

	@Override
	public void getHistoricalNav(String schemeCode, String schemeName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAllFundHouses() {
	     
		return mutalFundsDetailsRepo.getAllFundHouses();
	}

	@Override
	public List<String> getAllSchemeNamesByFundHouse(String fundHouse) {
	
		
		return mutalFundsDetailsRepo.getAllSchemeNamesByFundHouse(fundHouse);

	}

//	@Override
//	public List<MutualFundsDetails> saveHistoricalDate(List<MutualFundsDetailsDto> listDto) {
//		
//		List<MutualFundsDetails> list = new ArrayList<>();
//		 
//		for (MutualFundsDetailsDto dto :  listDto) {
//			MutualFundsDetails md = mutualFundMapper.convertToEntity(dto);
//			list.add(md);
//			mutalFundsDetailsRepo.save(md);
//		}
//	//	mutalFundsDetailsRepo.saveAll(list);
//		return list;
//	}


}
