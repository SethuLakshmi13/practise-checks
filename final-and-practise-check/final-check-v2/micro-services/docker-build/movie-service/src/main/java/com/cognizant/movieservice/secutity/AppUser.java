package com.cognizant.movieservice.secutity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.movieservice.model.Users;

public class AppUser implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Users user;
	private Collection<? extends GrantedAuthority> authorities;

	public AppUser(Users user) {

		this.user = user;
		this.authorities = user.getRoleList()
							.stream()
							.map(role -> new SimpleGrantedAuthority(role.getRole()))
							.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
	
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
