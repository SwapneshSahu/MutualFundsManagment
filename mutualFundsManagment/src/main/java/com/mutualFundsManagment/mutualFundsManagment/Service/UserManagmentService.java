package com.mutualFundsManagment.mutualFundsManagment.Service;

import org.springframework.stereotype.Service;

import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;

@Service
public interface UserManagmentService {

	public void createUser(UserInfo userInfo);
}
