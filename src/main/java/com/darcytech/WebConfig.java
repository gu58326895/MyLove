package com.darcytech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.darcytech.aop.LogInterceptor;

/**
 * Created by GXL on 2016/7/28.
 */

@Configuration
@EnableWebMvc
public class WebConfig  extends WebMvcConfigurerAdapter{

   @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter (){
        return new ServerEndpointExporter();
    }



}
