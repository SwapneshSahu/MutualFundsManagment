package com.mutualFundsManagment.mutualFundsManagment.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTResponse {

	private String userName;
	
	private String jwtToken;
}
