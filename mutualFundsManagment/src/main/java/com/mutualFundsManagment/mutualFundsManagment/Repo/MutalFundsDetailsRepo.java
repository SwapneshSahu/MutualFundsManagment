package com.mutualFundsManagment.mutualFundsManagment.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;

@Repository
public interface MutalFundsDetailsRepo extends JpaRepository<MutualFundsDetails, Long> {

	@Query(value = """
			SELECT * FROM mutual_funds_details 
			WHERE scheme_code =:schemeCode 
			ORDER BY Date DESC LIMIT  1
			""", nativeQuery = true)
	MutualFundsDetails findBySchemeCode(String schemeCode);
	
	
	@Query(value = """
			SELECT Distinct(scheme_name) FROM mutual_funds_details  mfd 
			WHERE  mutual_fund_family =:fundHouse
			""", nativeQuery = true)
	List<String> getAllSchemeNamesByFundHouse(String fundHouse);


	List<MutualFundsDetails> findAllBySchemeCode(String schemeCode);

	
	@Query(value = """
			SELECT Distinct(mutual_fund_family) FROM mutual_funds_details  mfd			
			""", nativeQuery = true)
	List<String> getAllFundHouses();


}
