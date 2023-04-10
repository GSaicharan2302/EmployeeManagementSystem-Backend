package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.repository.EmployeeRepo;

@Configuration
public class ApplicationConfig {
	
	@Autowired
	private EmployeeRepo er;
	@Bean
	public UserDetailsService userdetailsservice() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
				return er.findByUserEmail(username) ;
				
			}
		};
	}
		@Bean
		public AuthenticationProvider authenticationprovider() {
			DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
			authProvider.setUserDetailsService(userdetailsservice());
			authProvider.setPasswordEncoder(passwordEncoder());
			return authProvider;
		}
		
		@Bean
		public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
		{
			return config.getAuthenticationManager();
			
		}
		
		@Bean
		public PasswordEncoder passwordEncoder() {
			// TODO Auto-generated method stub
			return new BCryptPasswordEncoder();
		}
		
	}


