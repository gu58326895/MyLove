package com.darcytech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.darcytech.security.LoginSuccessHandler;
import com.darcytech.security.LoveAccessDecisionManager;
import com.darcytech.security.LoveAuthenticationProvider;
import com.darcytech.security.LoveMetadataSource;
import com.darcytech.service.LoveUserDetailService;

/**
 * Created by guxiaoli on 2017/2/9.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    LoveUserDetailService loveUserDetailService;

    @Bean
    public ReflectionSaltSource saltSource() {
        ReflectionSaltSource salt = new ReflectionSaltSource();
        salt.setUserPropertyToUse("salt");
        return salt;
    }

    @Bean
    public LoveAuthenticationProvider loveAuthenticationProvider() {
        LoveAuthenticationProvider provider = new LoveAuthenticationProvider();
        provider.setUserDetailsService(new LoveUserDetailService());
        return provider;
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LoveAccessDecisionManager poseidonAccessDecisionManager() {
        return new LoveAccessDecisionManager();
    }

    @Bean
    public LoveMetadataSource poseidonMetadataSource() {
        return new LoveMetadataSource();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home","/").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll().successHandler(loginSuccessHandler())
                .and().logout().logoutSuccessUrl("/home").permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(loveUserDetailService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}
