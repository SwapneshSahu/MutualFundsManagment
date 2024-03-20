package com.mutualFundsManagment.mutualFundsManagment.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.mutualFundsManagment.mutualFundsManagment.DTO.MutualFundsDetailsDto;
import com.mutualFundsManagment.mutualFundsManagment.Entity.MutualFundsDetails;
import com.mutualFundsManagment.mutualFundsManagment.Repo.MutalFundsDetailsRepo;
import com.mutualFundsManagment.mutualFundsManagment.Service.MutualFundsDetailsService;
import com.mutualFundsManagment.mutualFundsManagment.Utility.MutualFundMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mutualFundDetails")

public class MutualFundDetailsController {
	
	@Autowired
	private MutualFundsDetailsService mutualFundsDetailsService  ;

	private final WebClient webClient;
	
	private static final  String header1 = "X-RapidAPI-Key" ;
	private static final  String header1Value = "c13c1664e0mshd5815eb26ac0ce2p1f80cdjsn2b8533512e03";
	
	private static final  String header2 = "X-RapidAPI-Host" ;
	private static final  String header2Value = "latest-mutual-fund-nav.p.rapidapi.com";
	

	public MutualFundDetailsController(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("https://latest-mutual-fund-nav.p.rapidapi.com").build();
	}

	@GetMapping("/currentNav") //to do give option to search with scheme name 
	public ResponseEntity<List<MutualFundsDetails>> getCurrentNav(@RequestParam String schemeCode) {
		
		return ResponseEntity.ok( mutualFundsDetailsService.getCurrentNav(schemeCode));
	}

	@GetMapping("/historicalNav") // TO DO look for MONO
	public ResponseEntity<List<MutualFundsDetailsDto>> getHistoricalNav(@RequestParam String Date , @RequestParam String SchemCode) {
        
		List<MutualFundsDetailsDto> list = webClient.get()
				.uri(uriBuilder -> uriBuilder.path("/fetchHistoricalNAV").queryParam("Date", Date)
						 .queryParam("SchemeCode",SchemCode )
						// .queryParam("MutualFundFamily", "Kotak Mahindra Mutual Fund")
						.build())
				.header(header1, header1Value)
				.header(header2, header2Value).retrieve()
				.bodyToMono(ArrayList.class).block(); 
		
	
		return ResponseEntity.ok(list);
	}

	@GetMapping("/allFundNames")
	public ResponseEntity<List<String>> getAllFundHouses() {
		return ResponseEntity.ok( mutualFundsDetailsService.getAllFundHouses());
	}

	@GetMapping("/allSchemeNamesByFundHouse")
	public ResponseEntity<List<String>> getAllSchemeNamesByFundHouse(@RequestParam String fundHouse) {

		return ResponseEntity.ok( mutualFundsDetailsService.getAllSchemeNamesByFundHouse(fundHouse));
	}
	
	
}