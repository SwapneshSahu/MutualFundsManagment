package com.mutualFundsManagment.mutualFundsManagment.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mutualFundsManagment.mutualFundsManagment.Entity.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {

}
