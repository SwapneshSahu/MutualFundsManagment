package com.mutualFundsManagment.mutualFundsManagment.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(AbstractHttpConfigurer::disable)
//			.authorizeHttpRequests((authorize) -> authorize
//			  //   .requestMatchers("userFundDetails/*").permitAll()	     
//				 .anyRequest()
//				.authenticated()
//			).formLogin(Customizer.withDefaults());
		
		 http.csrf(AbstractHttpConfigurer::disable)
	        .authorizeHttpRequests((authorize) -> authorize
	            .anyRequest().authenticated()
	        );
		//  http.formLogin(fL -> fL.loginPage("/login"));
			

		return http.build();
	}
	
	@Bean
	 public UserDetailsService userDetailsService() {
//       UserDetails admin = User.withUsername("Basant")
//               .password(encoder.encode("Pwd1"))
//               .roles("ADMIN")
//               .build();
//       UserDetails user = User.withUsername("John")
//               .password(encoder.encode("Pwd2"))
//               .roles("USER","ADMIN","HR")
//               .build();
//       return new InMemoryUserDetailsManager(admin, user);
       return new UserInfoUserDetailsService();
   }

  
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }

   @Bean
   public AuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
       authenticationProvider.setUserDetailsService(userDetailsService());
       authenticationProvider.setPasswordEncoder(passwordEncoder());
       return authenticationProvider;
   }
}
