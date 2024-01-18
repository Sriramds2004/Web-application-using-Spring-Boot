package com.in28minsSpringBoot.MyFirstWebApp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails = User.withDefaultPasswordEncoder().username("in28mins").password("dummy").roles("USER","ADMIN").build();
		return new InMemoryUserDetailsManager (userDetails );
		
	}
	
	@Bean
	public SecurityFilterChain fliterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}



