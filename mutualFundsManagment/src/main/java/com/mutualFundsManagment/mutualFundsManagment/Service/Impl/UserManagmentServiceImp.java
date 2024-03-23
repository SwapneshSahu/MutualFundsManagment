package com.mutualFundsManagment.mutualFundsManagment.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;
import com.mutualFundsManagment.mutualFundsManagment.Repo.UserInfoRepository;
import com.mutualFundsManagment.mutualFundsManagment.Service.UserManagmentService;

@Service
public class UserManagmentServiceImp implements UserManagmentService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public void createUser(UserInfo userInfo) {
		
		  userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	   
		userInfoRepository.save(userInfo);
	}
	
	 public String addUser(UserInfo userInfo) {
	      
	        return "user added to system ";
	    }

}
