package com.cognizant.movieservice.secutity;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired 
	AppUserDetailsService appUserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("Start");
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		LOGGER.info("End");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
		
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("Start");
        httpSecurity.cors();
        httpSecurity
        	.csrf()
        	.disable()
        	.httpBasic()
        	.and()
            .authorizeRequests()
            .antMatchers("/movie-service/movie-list").anonymous()
            .antMatchers("/movie-service/movie-list").permitAll()
            .antMatchers("/movie-service/favorites").permitAll()
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
        LOGGER.info("End");

	}
	
	

}