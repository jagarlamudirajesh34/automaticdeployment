package com.test.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.modal.User;

public final class UserRepositoryUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;	
	
	
	public UserRepositoryUserDetails(User user,	Long id) {
		super(user);
		this.id = id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		GrantedAuthority grantedAuthority = new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				String authority = "ROLE_" + getUserRole().getUserType().toUpperCase();
				return authority;
			}
		};
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(grantedAuthority);
		
		return roles;
	}

	@Override
	public String getUsername() {
		return getMobile();
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
	
	public Long getid() {
		return id;
	}

}
