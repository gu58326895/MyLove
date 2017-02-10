package com.darcytech.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by guxiaoli on 2017/2/9.
 */
public class LoveAccessDecisionManager implements AccessDecisionManager {
    @Override
    /**
     * 判断用户是否有权限访问资源,若没有则抛出AccessDeniedException异常
     * 没有配置的资源,默认有权限访问
     */
    public void decide(Authentication authentication, Object url, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {


        if(configAttributes == null){
            return ;
        }
        Iterator<ConfigAttribute> ite=configAttributes.iterator();

        while(ite.hasNext()){

            ConfigAttribute ca=ite.next();

            String needRole=((SecurityConfig)ca).getAttribute();
            for(GrantedAuthority role:authentication.getAuthorities()){
                if(needRole.equals(role.getAuthority())){
                    return;
                }
            }
        }

        throw new AccessDeniedException("no right");

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {

        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {

        return true;
    }
}
