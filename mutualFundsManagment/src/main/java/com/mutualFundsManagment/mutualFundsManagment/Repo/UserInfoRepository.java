package com.mutualFundsManagment.mutualFundsManagment.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

	@Query(value = """
			SELECT * FROM user_info
			WHERE user_name =:username ;
			""", nativeQuery = true)
	Optional<UserInfo> findByName(String username);

}
