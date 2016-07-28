package com.darcytech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.darcytech.aop.LogInterceptor;

/**
 * Created by GXL on 2016/7/28.
 */

@Configuration
public class WebConfig {

   @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }
}
