package com.darcytech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import com.darcytech.security.LoginSuccessHandler;
import com.darcytech.security.LoveAuthenticationFilter;
import com.darcytech.security.LoveAuthenticationProvider;
import com.darcytech.service.impl.LoveUserDetailServiceImpl;

/**
 * Created by guxiaoli on 2017/2/9.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    UserDetailsService userDetailsService;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public LoveAuthenticationProvider loveAuthenticationProvider() {
        LoveAuthenticationProvider provider = new LoveAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LoveAuthenticationFilter loveAuthenticationFilter() throws Exception {
        LoveAuthenticationFilter filter = new LoveAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(loginSuccessHandler());
        filter.setAuthenticationManager(authenticationManager());
        filter.setFilterProcessesUrl("/denglu");
        return filter;
    }

    //暂时不加权限的角色控制
    /*@Bean
    public FilterSecurityInterceptor resourceSecurityInterceptor() throws Exception {
        FilterSecurityInterceptor interceptor = new FilterSecurityInterceptor();
        interceptor.setAuthenticationManager(authenticationManager());
        interceptor.setAccessDecisionManager(loveAccessDecisionManager());
        interceptor.setSecurityMetadataSource(loveMetadataSource());
        interceptor.setObserveOncePerRequest(false);
        return interceptor;
    }

    @Bean
    public LoveAccessDecisionManager loveAccessDecisionManager() {
        return new LoveAccessDecisionManager();
    }

    @Bean
    public LoveMetadataSource loveMetadataSource() {
        return new LoveMetadataSource();
    }*/


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll();
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll();
        http.headers().disable().csrf().disable();
        http.addFilterBefore(loveAuthenticationFilter(), ExceptionTranslationFilter.class);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loveAuthenticationProvider());
    }






}
