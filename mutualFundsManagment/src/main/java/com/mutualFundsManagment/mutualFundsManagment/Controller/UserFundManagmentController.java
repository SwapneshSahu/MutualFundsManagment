package com.mutualFundsManagment.mutualFundsManagment.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutualFundsManagment.mutualFundsManagment.DTO.UserFundsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserFunds;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserInfo;
import com.mutualFundsManagment.mutualFundsManagment.Repo.UserInfoRepository;
import com.mutualFundsManagment.mutualFundsManagment.Service.UserFundMangmentService;
import com.mutualFundsManagment.mutualFundsManagment.Service.UserManagmentService;

@RestController
@RequestMapping("/userFundDetails")
//@CrossOrigin(origins = "http://localhost:8082")
public class UserFundManagmentController {

	@Autowired
	private UserFundMangmentService userFundMangmentService;
	
	@Autowired
	private UserManagmentService userManagmentService;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	@PreAuthorize("hasAuthority('USER')")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/welcome") // TO DO look for MONO 
	public ResponseEntity<String> welcome( Principal principal) {
		return ResponseEntity.ok(String.format("Welcome User %s", principal.getName()));
	}
	
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/newUser") // TO DO look for MONO 
	public ResponseEntity<String> createNewUser(@RequestBody UserInfo userInfo) {
		userManagmentService.createUser(userInfo);
		return ResponseEntity.ok(String.format("User Created with Name  %s and Role %s ", userInfo.getUserName() ,userInfo.getRole()));
	}

//	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/buyFund") // TO DO look for MONO //to do give option to search with scheme name
	public ResponseEntity<UserFunds> buyMF(@RequestParam String schemeCode, @RequestParam double amount) {

		long userID = 1;
		UserInfo user = new UserInfo(userID, "Nirmala Devi", schemeCode, "fdfsdf");
		userInfoRepository.save(user);
		return ResponseEntity.ok(userFundMangmentService.buyFund(schemeCode, amount, user));
	}

	@PostMapping("/sellFund") // TO DO look for MONO //to do give option to search with scheme name
	public ResponseEntity<UserFundsDto> sellMF(@RequestParam String schemeCode) {

		long userID = 1; // to d=get user details from session
		UserInfo user = new UserInfo(userID, "Nirmala Devi", schemeCode, "password");
		userInfoRepository.save(user);
		return ResponseEntity.ok(userFundMangmentService.sellFund(schemeCode, user));
	}

	@GetMapping("/api")
	public String apiEndpoint() {
		// Assuming you have logic here to check if user is logged in or not
		boolean isLoggedIn = false; // Example logic, replace it with your actual logic
		if (!isLoggedIn) {
			return "redirect:/login"; // Redirect to login page if user is not logged in
		}
		return "api"; // Your API logic
	}

}
