package com.cognizant.truyum.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cognizant.truyum.security.JwtAuthorizationFilter;
import com.cognizant.truyum.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired 
	 AppUserDetailsService appUserDetailsService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

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
            .antMatchers("/menu-items/items").anonymous()
            .antMatchers("/menu-items/items").permitAll()
            .antMatchers("/cart").permitAll()
            .antMatchers("/users").anonymous()
            .antMatchers("/authenticate").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
        LOGGER.info("End");

	}
	
}