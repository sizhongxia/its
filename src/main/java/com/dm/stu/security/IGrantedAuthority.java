package com.dm.stu.security;

import org.springframework.security.core.GrantedAuthority;

public class IGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	private String authority;

	public IGrantedAuthority() {
		super();
	}

	public IGrantedAuthority(String authority) {
		super();
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

}
