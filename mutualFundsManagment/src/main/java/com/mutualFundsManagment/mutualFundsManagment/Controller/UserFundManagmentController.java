package com.mutualFundsManagment.mutualFundsManagment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mutualFundsManagment.mutualFundsManagment.DTO.UserFundsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserDetails;
import com.mutualFundsManagment.mutualFundsManagment.Entity.UserFunds;
import com.mutualFundsManagment.mutualFundsManagment.Repo.UserDetailsRepo;
import com.mutualFundsManagment.mutualFundsManagment.Service.UserFundMangmentService;

@RestController
@RequestMapping("/userFundDetails")
public class UserFundManagmentController {
	
	@Autowired
	private UserFundMangmentService userFundMangmentService;
	
	@Autowired
	private UserDetailsRepo userDetailsRepo;

	@PostMapping("/buyFund") // TO DO look for MONO  //to do give option to search with scheme name 
	public ResponseEntity<UserFunds> buyMF(@RequestParam String schemeCode ,@RequestParam double amount) {
       
		long userID = 1; 
		UserDetails user = new UserDetails(userID,"Nirmala Devi", schemeCode);
		userDetailsRepo.save(user);
		return ResponseEntity.ok(userFundMangmentService.buyFund(schemeCode, amount, user));
	}
	
	@PostMapping("/sellFund") // TO DO look for MONO  //to do give option to search with scheme name 
	public ResponseEntity<UserFundsDto> sellMF(@RequestParam String schemeCode) {
       
		long userID = 1;  // to d=get user details from session
		UserDetails user = new UserDetails(userID,"Nirmala Devi", schemeCode);
		userDetailsRepo.save(user);
		return ResponseEntity.ok(userFundMangmentService.sellFund(schemeCode,user));
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
