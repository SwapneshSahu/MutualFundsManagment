package com.mutualFundsManagment.mutualFundsManagment.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mutualFundsManagment.mutualFundsManagment.Entity.UserFunds;


@Repository
public interface UserFundRepo extends JpaRepository<UserFunds, Long>{

	@Query(value = """
			SELECT * FROM user_funds 
			WHERE scheme_code =:schemeCode  AND 
			user_details_id =:userId		
			""", nativeQuery = true)
	UserFunds getByUserIdAndSchemeCode(long userId, String schemeCode);

}
