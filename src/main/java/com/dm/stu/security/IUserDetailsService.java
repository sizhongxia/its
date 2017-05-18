package com.dm.stu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dm.stu.domain.User;
import com.dm.stu.service.UserService;

public class IUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.getUserByLoginame(username);
		if (user == null) {
			throw new UsernameNotFoundException("无效的用户名");
		}
		IUserDetails userDetails = new IUserDetails(user);
		userDetails.addAuthority(new IGrantedAuthority("ROLE_user"));
		return userDetails;
	}

}
