package com.mutualFundsManagment.mutualFundsManagment.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	// @Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////		http.csrf(AbstractHttpConfigurer::disable)
////			.authorizeHttpRequests((authorize) -> authorize
////			  //   .requestMatchers("userFundDetails/*").permitAll()	     
////				 .anyRequest()
////				.authenticated()
////			).formLogin(Customizer.withDefaults());
//
//		// normal
//		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
//				.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
//				.formLogin(Customizer.withDefaults());
//
//		
//		
//		return http.build();
//	}

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
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
}
