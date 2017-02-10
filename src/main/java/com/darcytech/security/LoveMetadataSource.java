package com.darcytech.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * Created by guxiaoli on 2017/2/10.
 */
public class LoveMetadataSource implements FilterInvocationSecurityMetadataSource {


    private Map<String, List<ConfigAttribute>> mp; //url对应角色

    public LoveMetadataSource() {
        this.mp = new HashMap<String, List<ConfigAttribute>>();
        List<ConfigAttribute> adminList = new ArrayList<ConfigAttribute>();
        ConfigAttribute admin = new SecurityConfig("Role_ADMIN"); // 构造一个权限(角色)
        ConfigAttribute user = new SecurityConfig("Role_USER"); // 构造一个权限(角色)
        adminList.add(admin);
        adminList.add(user);
        mp.put("/admin/*",adminList);

    }



    @Override
    public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
        String requestURI = ((FilterInvocation)filter).getRequest().getRequestURI();
        if(requestURI.startsWith("/admin/")){
            List<ConfigAttribute> adminList = new ArrayList<ConfigAttribute>();
            ConfigAttribute admin = new SecurityConfig("Role_ADMIN"); // 构造一个权限(角色)
            ConfigAttribute user = new SecurityConfig("Role_USER"); // 构造一个权限(角色)
            adminList.add(admin);
            adminList.add(user);
            return adminList;
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
