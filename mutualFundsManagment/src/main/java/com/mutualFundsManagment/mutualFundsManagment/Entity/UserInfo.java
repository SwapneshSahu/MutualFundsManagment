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
public class UserInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String role;
	private String password;
		
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL)
	private Set<UserFunds> userFunds = new HashSet<>();

	public UserInfo(Long userId, String userName, String role, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.role = role;
		this.password = password;
	}
	 
	
}




