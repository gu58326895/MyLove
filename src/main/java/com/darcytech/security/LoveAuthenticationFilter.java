package com.darcytech.security;

import java.net.PasswordAuthentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by guxiaoli on 2017/2/10.
 */
public class LoveAuthenticationFilter extends UsernamePasswordAuthenticationFilter {




    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }
        username = username.trim();

        LoveAuthenticationToken token = new LoveAuthenticationToken(username, password);

        return this.getAuthenticationManager().authenticate(token);
    }

}
