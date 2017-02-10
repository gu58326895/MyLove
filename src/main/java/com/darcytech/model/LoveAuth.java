package com.darcytech.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by guxiaoli on 2017/2/10.
 */
public class LoveAuth implements GrantedAuthority {

    private String auth;

    LoveAuth(String auth){
        this.auth = auth;
    }

    @Override
    public String getAuthority() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
}


