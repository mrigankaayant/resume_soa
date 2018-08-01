package com.ayantsoft.resume.security.oauth;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2542921159380408812L;
	
	private final String authority;
	
	public GrantedAuthorityImpl(String authority){
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}