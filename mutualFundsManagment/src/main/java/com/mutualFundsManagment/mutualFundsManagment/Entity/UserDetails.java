package com.mutualFundsManagment.mutualFundsManagment.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class UserDetails {
	
	public UserDetails(Long userId, String userName,String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String role;
		
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private Set<UserFunds> userFunds = new HashSet<>();
	 
	
}




