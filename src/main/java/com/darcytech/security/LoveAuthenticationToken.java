package com.darcytech.security;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by guxiaoli on 2017/2/9.
 */
public class LoveAuthenticationToken extends AbstractAuthenticationToken {


    private String username;

    private Object principal;

    private Object credentials;

    public LoveAuthenticationToken() {
        super(null);
    }

    public LoveAuthenticationToken(String username, Object credentials) {
        super(null);
        this.username = username;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    LoveAuthenticationToken(Object principal){
        super(null);
        this.principal = principal;
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
