package com.dm.stu.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

import com.dm.stu.domain.User;

public class IUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private Collection<IGrantedAuthority> authorities = new ArrayList<IGrantedAuthority>();

	public IUserDetails(User user) {
		this.username = user.getPhoneNumber();
		this.password = user.getPassword();
		this.accountNonLocked = !user.getAccountLocked();
		this.enabled = user.getAccountEnabled();
		this.accountNonExpired = true;
		this.credentialsNonExpired = true;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void addAuthority(IGrantedAuthority authority) {
		if (this.authorities == null) {
			this.authorities = new ArrayList<IGrantedAuthority>();
		}
		this.authorities.add(authority);
	}

	public void setAuthorities(Collection<IGrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<IGrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}
