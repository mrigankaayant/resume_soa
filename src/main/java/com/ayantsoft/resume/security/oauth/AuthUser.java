package com.ayantsoft.resume.security.oauth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ayantsoft.resume.pojo.UserMst;

public class AuthUser extends User{
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = 2754015619606313499L;
	
	
	private UserMst userMst;

	public AuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public UserMst getUserMst() {
		return userMst;
	}
	public void setUserMst(UserMst userMst) {
		this.userMst = userMst;
	}
}