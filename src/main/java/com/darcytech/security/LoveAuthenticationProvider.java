package com.darcytech.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;

import com.darcytech.model.User;

/**
 * Created by guxiaoli on 2017/2/9.
 */
public class LoveAuthenticationProvider extends DaoAuthenticationProvider {





    @Override
    public Authentication authenticate(Authentication authentication){



        LoveAuthenticationToken token = (LoveAuthenticationToken) authentication;

        User loadedUser = (User) this.getUserDetailsService().loadUserByUsername(token.getUsername());

        checkUser(loadedUser,token);

        return new LoveAuthenticationToken(loadedUser);

    }




    private void checkUser(User loadUser, LoveAuthenticationToken token) {
        if (token.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

        if(!this.getPasswordEncoder().isPasswordValid(loadUser.getPassword(),
                token.getCredentials().toString(),null)){
            logger.debug("Authentication failed: password does not match stored value");

            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (LoveAuthenticationToken.class
                .isAssignableFrom(authentication));
    }




}
